package com.peony.peonydata.area.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.peonydata.area.model.Area;
import com.peony.peonydata.area.service.AreaService;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.util.JSONUtil;

/**
 * 区域维护
 * @author jhj
 * @version 1
 */

@Controller
@RequestMapping("/area")
public class AreaController extends BaseController {

	@Autowired
	private AreaService areaService; // 区域服务接口

	@Autowired
	private IdService idService; // 部门服务接口
	/**
	 * 根据id加载部门
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/areaList", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<Area> areaList = this.areaService.selectAreas();
		List<ZTreeNode> nodes = nodeList(areaList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("area/list_area");
		return mv;
	}
	
	
	/**
	 * 根据id加载地域
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loadArea/{id}", method = RequestMethod.GET)
	public ModelAndView loadDept(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		Area area = this.areaService.selectByPrimaryKey(id);
		request.setAttribute("area", area);

		return new ModelAndView("area/area_info");
	}

	/**
	 * 修改区域
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editArea/{id}")
	public ModelAndView editArea(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		List<Area> areaList = areaService.selectAreas();
		List<ZTreeNode> nodes = nodeList(areaList, String.valueOf(id));
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		Area area = areaService.selectByPrimaryKey(id);
		mv.addObject("area", area);
		mv.setViewName("area/edit_area");
		return mv;
	}

	/**
	 * 保存修改
	 * 
	 * @param area
	 * @return
	 */
	@RequestMapping(value = "/updateArea")
	@ResponseBody
	public String updateArea(@ModelAttribute("area") Area area) {
		this.areaService.updateByPrimaryKeySelective(area);
		return "";
	}

	/**
	 * 增加area
	 * @return
	 */
	@RequestMapping(value = "/addArea")
	public ModelAndView addArea() {
		ModelAndView mv = new ModelAndView();
		List<Area> areaList = areaService.selectAreas();
		List<ZTreeNode> nodes = nodeList(areaList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("area/add_area");
		return mv;
	}

	/**
	 * 保存增加
	 * 
	 * @param area
	 * @return
	 */
	@RequestMapping(value = "/saveArea")
	@ResponseBody
	public String saveArea(@ModelAttribute("area") Area area) {
		area.setAreaId(idService.NextKey("area_id"));
		areaService.insertSelective(area);
		return "";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteArea")
	@ResponseBody
	public String deleteArea(
			@RequestParam(value = "id", required = true) int id) {
		areaService.deleteByPrimaryKey(id);
		return "";
	}

	
	
	@RequestMapping(value = "/findChildren")
	@ResponseBody
	public List<ZTreeNode> findChildren(Model model, HttpServletRequest request) {
		// id = null 查父子节点
		String parentCode = request.getParameter("id");
		if (null == parentCode || "".equals(parentCode)) {
			parentCode = "0";
		}
		List<Area> list = areaService.findChildren(parentCode);
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());

		for (Area area : list) {
			ZTreeNode node = new ZTreeNode();
			node.setId(String.valueOf(area.getAreaId()));
			node.setName(area.getName());
			node.setOpen(true);
			node.setIsParent(areaService.loadHasChildren(String.valueOf(area
					.getAreaId())) ? "true" : "false");
			node.setHasUser(areaService.loadHasKeyWords(String.valueOf(area
					.getAreaId())));
			nodeList.add(node);
		}
		return nodeList;
	}
	
	/**
	 * 返回ztree列表
	 * 
	 * @param list
	 * @return
	 */
	public List<ZTreeNode> nodeList(List<Area> list, String checkid) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());
		String pid = "";
		for (Area area : list) {
			if (checkid.equals(String.valueOf(area.getAreaId()))) {
				pid = String.valueOf(area.getAreaPid());
				break;
			}
		}
		for (Area area : list) {
			ZTreeNode node = new ZTreeNode();
			if (pid.equals(String.valueOf(area.getAreaId()))) {
				node.setChecked(true);
			}
			node.setId(String.valueOf(area.getAreaId()));
			node.setPId(String.valueOf(area.getAreaPid()));
			node.setName(area.getName());
			node.setOpen(true);
			node.setIsParent(areaService.loadHasChildren(String.valueOf(area
					.getAreaId())) ? "true" : "false");
			nodeList.add(node);
		}
		return nodeList;

	}
}
