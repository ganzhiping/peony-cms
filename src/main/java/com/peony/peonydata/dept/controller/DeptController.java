package com.peony.peonydata.dept.controller;

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
import com.peony.peonydata.dept.model.Dept;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.dept.service.DeptService;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.util.JSONUtil;

/**
 * 部门 controller
 * 
 * @date 2013-10-24 下午05:38:49
 * @author zhaoshutao
 * @version 1
 */

@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {

	@Autowired
	private DeptService deptService; // 部门服务接口
	@Autowired
	private IdService idService; // 部门服务接口

	/**
	 * 根据id加载部门
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/deptList", method = RequestMethod.GET)
	public ModelAndView deptList() {
		ModelAndView mv = new ModelAndView();
		List<Dept> deptList = deptService.selectDepts();
		List<ZTreeNode> nodes = nodeList(deptList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("dept/list_dept");
		return mv;
	}

	/**
	 * 根据id加载部门
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loadDept/{id}", method = RequestMethod.GET)
	public ModelAndView loadDept(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		Dept dept = deptService.selectByPrimaryKey(id);
		request.setAttribute("dept", dept);

		return new ModelAndView("dept/dept_info");
	}

	/**
	 * 查询全部部门 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectDeptByPage", method = RequestMethod.GET)
	public ModelAndView selectDeptByPage() {

		return new ModelAndView("dept/dept_info");
	}

	/**
	 * 查询全部部门
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectDepts")
	public @ResponseBody
	List<ZTreeNode> selectDepts(@ModelAttribute("dept") Dept dept, String id) {
		List<Dept> deptList = deptService.selectDepts();
		List nodeList = nodeList(deptList, id);
		return nodeList;
	}

	/**
	 * 修改部门
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editDept/{id}")
	public ModelAndView editDept(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		List<Dept> deptList = deptService.selectDepts();
		List<ZTreeNode> nodes = nodeList(deptList, String.valueOf(id));
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		Dept dept = deptService.selectByPrimaryKey(id);
		mv.addObject("dept", dept);
		mv.setViewName("dept/edit_dept");
		return mv;
	}

	/**
	 * 保存修改
	 * 
	 * @param dept
	 * @return
	 */
	@RequestMapping(value = "/updateDept")
	public @ResponseBody
	String updateDept(@ModelAttribute("dept") Dept dept) {
		deptService.updateByPrimaryKeySelective(dept);
		return "";
	}

	/**
	 * 增加部门
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addDept", method = RequestMethod.GET)
	public ModelAndView addDept() {
		ModelAndView mv = new ModelAndView();
		List<Dept> deptList = deptService.selectDepts();
		List<ZTreeNode> nodes = nodeList(deptList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("dept/add_dept");
		return mv;
	}

	/**
	 * 保存增加
	 * 
	 * @param dept
	 * @return
	 */
	@RequestMapping(value = "/saveDept")
	@ResponseBody
	public String saveDept(@ModelAttribute("dept") Dept dept) {
		dept.setDeptId(idService.NextKey("dept_id"));
		deptService.insertSelective(dept);
		return "";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteDept")
	@ResponseBody
	public String deleteDept(
			@RequestParam(value = "id", required = true) int id) {
		
		List<Dept> list = deptService.findChildren(String.valueOf(id));
		if(list.size()>0){//非叶子节点
			for(Dept dept:list){
				deptService.deleteByPrimaryKey(dept.getDeptId());
			}
			
		}
		
		deptService.deleteByPrimaryKey(id);
		//TODO xxxdelete chi
		return "";
	}

	@RequestMapping(value = "/findChildren")
	public @ResponseBody
	List<ZTreeNode> findChildren(Model model, HttpServletRequest request) {
		// id = null 查父子节点
		String parentCode = request.getParameter("id");
		if (null == parentCode || "".equals(parentCode)) {
			parentCode = "0";
		}
		List<Dept> list = deptService.findChildren(parentCode);
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());

		for (Dept dpt : list) {
			ZTreeNode node = new ZTreeNode();
			node.setId(String.valueOf(dpt.getDeptId()));
			node.setName(dpt.getName());
			node.setOpen(true);
			node.setIsParent(deptService.loadHasChildren(String.valueOf(dpt
					.getDeptId())) ? "true" : "false");
			node.setHasUser(deptService.loadHasUser(String.valueOf(dpt
					.getDeptId())));
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
	public List<ZTreeNode> nodeList(List<Dept> list, String checkid) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());
		String pid = "";
		for (Dept dpt1 : list) {
			if (checkid.equals(String.valueOf(dpt1.getDeptId()))) {
				pid = dpt1.getDeptPid();
				break;
			}
		}
		for (Dept dpt : list) {
			ZTreeNode node = new ZTreeNode();
			if (pid.equals(String.valueOf(dpt.getDeptId()))) {
				node.setChecked(true);
			}
			node.setId(String.valueOf(dpt.getDeptId()));
			node.setPId(dpt.getDeptPid());
			node.setName(dpt.getName());
			node.setOpen(true);
			node.setIsParent(deptService.loadHasChildren(String.valueOf(dpt
					.getDeptId())) ? "true" : "false");
			nodeList.add(node);
		}
		return nodeList;

	}
}
