package com.peony.peonydata.baseclass.controller;

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
import com.peony.peonydata.baseclass.model.BaseClass;
import com.peony.peonydata.baseclass.service.BaseClassService;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.util.JSONUtil;

/**
 * 基础关键字类别维护
 * @author jhj
 * @version 1
 */

@Controller
@RequestMapping("/baseclass")
public class BaseClassController extends BaseController {

	@Autowired
	private BaseClassService baseClassService; // 基础关键字类别服务接口

	@Autowired
	private IdService idService; // id
	
	/**
	 * 根据id加载基础类型
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/baseClassList", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<BaseClass> baseClassList = this.baseClassService.selectBaseClass(0);
		List<ZTreeNode> nodes = nodeList(baseClassList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("baseclass/list_baseclass");
		return mv;
	}
	
	
	/**
	 * 根据id加载地域
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loadBaseClass/{id}", method = RequestMethod.GET)
	public ModelAndView loadDept(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		BaseClass baseClass = this.baseClassService.selectByPrimaryKey(id);
		request.setAttribute("baseClass", baseClass);

		return new ModelAndView("baseclass/baseclass_info");
	}

	/**
	 * 修改基础类型
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editBaseClass/{id}")
	public ModelAndView editBaseClass(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		List<BaseClass> baseClassList = baseClassService.selectBaseClass(0);
		List<ZTreeNode> nodes = nodeList(baseClassList, String.valueOf(id));
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		BaseClass baseClass = baseClassService.selectByPrimaryKey(id);
		
		BaseClass father=this.baseClassService.selectByPrimaryKey(baseClass.getBaseclassPid());
		String fatherName="";
		if(father!=null){
			fatherName=father.getName();
		}
		
		mv.addObject("fatherName",fatherName);
		mv.addObject("baseClass", baseClass);
		mv.setViewName("baseclass/edit_baseclass");
		return mv;
	}

	/**
	 * 保存修改
	 * 
	 * @param baseClass
	 * @return
	 */
	@RequestMapping(value = "/updateBaseClass")
	@ResponseBody
	public String updateBaseClass(@ModelAttribute("baseClass") BaseClass baseClass) {
		this.baseClassService.updateByPrimaryKeySelective(baseClass);
		return "";
	}

	/**
	 * 增加baseclass
	 * @return
	 */
	@RequestMapping(value = "/addBaseClass")
	public ModelAndView addBaseClass() {
		ModelAndView mv = new ModelAndView();
		List<BaseClass> baseClassList = baseClassService.selectBaseClass(0);
		List<ZTreeNode> nodes = nodeList(baseClassList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("baseclass/add_baseclass");
		return mv;
	}

	/**
	 * 保存增加
	 * 
	 * @param baseclass
	 * @return
	 */
	@RequestMapping(value = "/saveBaseClass")
	@ResponseBody
	public String saveBaseClass(@ModelAttribute("baseClass") BaseClass baseClass) {
		baseClass.setBaseclassId(idService.NextKey("BaseClass_id"));
		baseClassService.insertSelective(baseClass);
		return "";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteBaseClass")
	@ResponseBody
	public String deleteBaseClass(
			@RequestParam(value = "id", required = true) int id) {
		baseClassService.deleteByPrimaryKey(id);
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
		List<BaseClass> list = baseClassService.findChildren(parentCode);
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());

		for (BaseClass baseClass : list) {
			ZTreeNode node = new ZTreeNode();
			node.setId(String.valueOf(baseClass
					.getBaseclassId()));
			node.setName(baseClass.getName());
			node.setOpen(true);
			node.setIsParent(baseClassService.loadHasChildren(String.valueOf(baseClass
					.getBaseclassId())) ? "true" : "false");
			node.setHasUser(baseClassService.loadHasKeyWords(String.valueOf(baseClass.getBaseclassId())));
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
	public List<ZTreeNode> nodeList(List<BaseClass> list, String checkid) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());
		
		for (BaseClass baseClass : list) {
			ZTreeNode node = new ZTreeNode();
			
			node.setId(String.valueOf(baseClass.getBaseclassId()));
			node.setPId(String.valueOf(baseClass.getBaseclassPid()));
			node.setName(baseClass.getName());
			node.setIsParent(baseClassService.loadHasChildren(String.valueOf(baseClass
					.getBaseclassId())) ? "true" : "false");
			nodeList.add(node);
		}
		return nodeList;

	}
}
