package com.peony.peonydata.areakeyws.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.area.model.Area;
import com.peony.peonydata.area.service.AreaService;
import com.peony.peonydata.areakeyws.model.AreaKeyws;
import com.peony.peonydata.areakeyws.service.AreakeywsService;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.util.JSONUtil;

/**
 * 区域关键字
 * @authorjhj
 *
 */
@Controller
@RequestMapping("/areakeyws")
public class AreakeywsController extends BaseController{

	@Autowired
	private AreaService areaService; 
	
	@Autowired
	private AreakeywsService areakeywsService;
	
	@Autowired
	private IdService idService;
	
	
	/**
	 * 跳转到区域树
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/areaList")
	public ModelAndView areaList() {
		ModelAndView mv=new ModelAndView();
		List<Area> areaList = this.areaService.selectAreas();
		List<ZTreeNode> nodes = nodeList(areaList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("areakeyws/area_tree");
		return mv;
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
	/**
	 * 跳转到区域关键字列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/areakeywsList")
	public ModelAndView list(@RequestParam(value = "areaId", required = true) int areaId) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("areaId",areaId);
		mv.setViewName("areakeyws/list_areakeyws");
		return mv;
	}

	/**
	 * 区域关键字列表  帶分页  根据areaId 获取关键字列表
	 * @param request areaId
	 * @param response
	 * @return
	 */
	 @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	 @ResponseBody
	 public Pagination<AreaKeyws> selectByPage(@ModelAttribute("areaKeyws") AreaKeyws areaKeyws,
			HttpServletRequest request) {
		areaKeyws.setPageParameter(getpagePageParameter());
		Pagination<AreaKeyws> pagination = this.areakeywsService.selectByPage(areaKeyws);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
	
	

	/**
	 * 跳转到 --跳转到区域关键字
	 * @param areaId
	 * @return mv
	 */
	@RequestMapping(value = "/addAreakeyws", method = RequestMethod.GET)
	public ModelAndView addAreakeyws(@RequestParam(value = "areaId", required = true) int areaId) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("areaId", areaId);
		mv.setViewName("areakeyws/add_areakeyws");
		return mv;
	}

	/**
	 * 保存增加区域关键字
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/saveAreakeyws", method = { RequestMethod.POST })
	@ResponseBody
	public String saveAreakeyws(HttpServletRequest request, AreaKeyws areakeyws,HttpServletResponse response) {
		
		int id=this.idService.NextKey("areakeyws");
		areakeyws.setAreaKeywsId(id);
		areakeyws.setCreateTime(new Date());
		this.areakeywsService.insert(areakeyws);
		return "";
	}

	
	/**
	 * 跳转到 --跳转到修改区域关键字
	 * @param areaId
	 * @return mv
	 */
	@RequestMapping(value = "/editAreakeyws", method = RequestMethod.GET)
	public ModelAndView editAreakeyws(@RequestParam(value = "areaKeywsId", required = true) int areaKeywsId) {
		ModelAndView mv=new ModelAndView();
	    AreaKeyws areaKeyws=this.areakeywsService.selectByPrimaryKey(areaKeywsId);
	    
		mv.addObject("areaKeyws", areaKeyws);
		mv.setViewName("areakeyws/edit_areakeyws");
		return mv;
	}

	
	/**
	 * 修改保存
	 * @param areaId
	 * @return mv
	 */
	@RequestMapping(value = "/updateAreakeyws", method = RequestMethod.POST)
	@ResponseBody
	public String updateAreakeyws(HttpServletRequest request, AreaKeyws areakeyws) {
	    this.areakeywsService.updateByPrimaryKeySelective(areakeyws);
	    logger.info("update areakeyws success!");
		return "";
		}
	/**
	 * 删除区域关键字
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteAreakeyws")
	@ResponseBody
	public String deleteAreakeyws(@RequestParam(value = "areaKeywsId", required = true) int id) {
		this.areakeywsService.deleteByPrimaryKey(id);
		logger.info("delete areakeyws success !");
		return "";
	}
}
