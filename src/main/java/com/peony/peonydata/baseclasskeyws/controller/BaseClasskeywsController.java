package com.peony.peonydata.baseclasskeyws.controller;

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
import com.peony.peonydata.baseclass.model.BaseClass;
import com.peony.peonydata.baseclass.service.BaseClassService;
import com.peony.peonydata.baseclasskeyws.model.BaseClassKeyws;
import com.peony.peonydata.baseclasskeyws.service.BaseClassKeywsService;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.util.JSONUtil;

/**
 * 基础类型关键字
 * @authorjhj
 *
 */
@Controller
@RequestMapping("/baseClasskeyws")
public class BaseClasskeywsController extends BaseController{

	@Autowired
	private BaseClassKeywsService baseClassKeywsService; 
	
	@Autowired
	private BaseClassService baseClassService;
	
	@Autowired
	private IdService idService;
	
	
	/**
	 * 跳转到基础类型树
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/baseClassList")
	public ModelAndView baseClassList() {
		ModelAndView mv=new ModelAndView();
		List<BaseClass> baseClassList = this.baseClassService.selectBaseClass(0);
		List<ZTreeNode> nodes = nodeList(baseClassList, "0");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("baseclasskeyws/baseclass_tree");
		return mv;
	}
	/**
	 * 返回ztree列表
	 * 
	 * @param list
	 * @return
	 */
	public List<ZTreeNode> nodeList(List<BaseClass> list, String checkid) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());
		String pid = "";
		
		for (BaseClass baseClass : list) {
			ZTreeNode node = new ZTreeNode();
			if (pid.equals(String.valueOf(baseClass.getBaseclassId()))) {
				node.setChecked(true);
			}
			node.setId(String.valueOf(baseClass.getBaseclassId()));
			node.setPId(String.valueOf(baseClass.getBaseclassPid()));
			node.setName(baseClass.getName());
			node.setOpen(true);
			node.setIsParent(baseClassService.loadHasChildren(String.valueOf(baseClass.getBaseclassId())) ? "true" : "false");
			nodeList.add(node);
		}
		return nodeList;

	}
	/**
	 * 跳转到基本类型关键字列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/baseClasskeywsList")
	public ModelAndView list(@RequestParam(value = "baseclassId", required = true) int baseclassId) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("baseclassId",baseclassId);
		mv.setViewName("baseclasskeyws/list_baseclasskeyws");
		return mv;
	}

	/**
	 * 基本类型关键字列表  帶分页  根据baseClassId 获取关键字列表
	 * @param request baseClassId
	 * @param response
	 * @return
	 */
	 @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	 @ResponseBody
	 public Pagination<BaseClassKeyws> selectByPage(@ModelAttribute("baseClassKeyws") BaseClassKeyws baseClassKeyws,
			HttpServletRequest request) {
	    baseClassKeyws.setPageParameter(getpagePageParameter());
		Pagination<BaseClassKeyws> pagination = this.baseClassKeywsService.selectByPage(baseClassKeyws);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
	
	

	/**
	 * 跳转到基础类型关键字添加
	 * @param areaId
	 * @return mv
	 */
	@RequestMapping(value = "/addBaseClasskeyws", method = RequestMethod.GET)
	public ModelAndView addBaseClasskeyws(@RequestParam(value = "baseclassId", required = true) int baseclassId) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("baseclassId", baseclassId);
		mv.setViewName("baseclasskeyws/add_baseclasskeyws");
		return mv;
	}

	/**
	 * 保存增加基础类别关键字
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/saveBaseClasskeyws", method = { RequestMethod.POST })
	@ResponseBody
	public String saveBaseClasskeyws(HttpServletRequest request, BaseClassKeyws baseClassKeyws,HttpServletResponse response) {
		
		int id=this.idService.NextKey("BaseClasskeyws");
		baseClassKeyws.setBaseclassKeywsId(id);
		baseClassKeyws.setCreateTime(new Date());
		
		/*String keyws=StringRegular.remove(baseClassKeyws.getName());
		keyws=StringRegular.removeSpace(keyws);
		baseClassKeyws.setName(keyws);*/
		
		
		this.baseClassKeywsService.insert(baseClassKeyws);
		return "";
	}

	
	/**
	 * 跳转到 --跳转到修改区域关键字
	 * @param baseclassKeywsId
	 * @return mv
	 */
	@RequestMapping(value = "/editBaseClasskeyws")
	public ModelAndView editBaseClasskeyws(@RequestParam(value = "baseclassKeywsId", required = true) int baseclassKeywsId) {
		ModelAndView mv=new ModelAndView();
		BaseClassKeyws baseClassKeyws=this.baseClassKeywsService.selectByPrimaryKey(baseclassKeywsId);
	    
		mv.addObject("baseClassKeyws", baseClassKeyws);
		mv.setViewName("baseclasskeyws/edit_baseclasskeyws");
		return mv;
	}

	
	/**
	 * 修改保存
	 * @param 
	 * @return mv
	 */
	@RequestMapping(value = "/updateBaseClasskeyws", method = RequestMethod.POST)
	@ResponseBody
	public String updateBaseClasskeyws(HttpServletRequest request, BaseClassKeyws baseClassKeyws) {
	    this.baseClassKeywsService.updateByPrimaryKeySelective(baseClassKeyws);
	    logger.info("update baseClassKeyws success!");
		return "";
		}
	/**
	 * 删除基本类型关键字
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteBaseClassKeyws")
	@ResponseBody
	public String deleteBaseClassKeyws(@RequestParam(value = "baseclassKeywsId", required = true) int id) {
		this.baseClassKeywsService.deleteByPrimaryKey(id);
		logger.info("delete baseclassKeyws success !");
		
		return "";
	}
}
