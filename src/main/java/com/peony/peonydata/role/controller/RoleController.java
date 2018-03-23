package com.peony.peonydata.role.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.dept.model.Dept;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.dept.service.DeptService;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.role.model.Role;
import com.peony.peonydata.role.service.RoleService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;

/**
 * 角色 controller
 *  
 * @date 2013-10-24 下午05:38:49
 * @author zhaoshutao
 * @version 1
 */

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	private RoleService roleService; // 角色服务接口
	@Autowired
	private IdService idService; // id服务接口
	@Autowired
	private DeptService deptService; // 部门服务接口
	@Autowired
	private UserService userService; // 用户服务接口

	/**
	 * 查询全部角色
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/roleList", method = RequestMethod.GET)
	public ModelAndView roleList() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("role/list_role");
		return mv;
	}

	/**
	 * 根据id加载角色
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loadRole/{id}", method = RequestMethod.GET)
	public ModelAndView loadRole(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		// int usid = idService.getNextKey("role_id");
		Role role = roleService.selectByPrimaryKey(id);
		request.setAttribute("role", role);

		return new ModelAndView("role/role_info");
	}

	/**
	 * 查询全部角色 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	public @ResponseBody
	Pagination<Role> selectByPage(@ModelAttribute("role") Role role,
			HttpServletRequest request) {
		role.setPageParameter(getpagePageParameter());
		role.setOrderFields(request.getParameter("orderFields"));
		role.setOrder(request.getParameter("order"));
		Pagination<Role> pagination = roleService.selectByPage(role);
		request.setAttribute("list", pagination);
		return pagination;
	}

	/**
	 * 查询全部角色 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/editRole/{id}", method = RequestMethod.GET)
	public ModelAndView editRole(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		Role role = roleService.selectByPrimaryKey(id);
		request.setAttribute("role", role);
		return new ModelAndView("role/edit_role");
	}

	/**
	 * 查询全部角色 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updateRole", method = RequestMethod.POST)
	public @ResponseBody
	String updateRole(@ModelAttribute("role") Role role) {
		roleService.updateByPrimaryKeySelective(role);
		return "";
	}

	/**
	 * 查询全部角色 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addRole", method = RequestMethod.GET)
	public ModelAndView addRole(@ModelAttribute("role") Role role) {

		return new ModelAndView("role/add_role");
	}

	/**
	 * 查询全部角色 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/saveRole", method = RequestMethod.POST)
	public @ResponseBody
	String saveRole(@ModelAttribute("role") Role role) {
		role.setRoleId(idService.NextKey("role_id"));
		role.setCreateTime(new Date());
		roleService.insertSelective(role);
		return "";
	}

	/**
	 * 查询全部角色 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	public @ResponseBody
	String deleteRole(@RequestParam(value = "id", required = true) int id) {
		roleService.deleteByPrimaryKey(id);
		return "";
	}

	
	/**
	 * 获取角色信息
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/assignRole", method = RequestMethod.GET)
	public ModelAndView assignRole(@ModelAttribute("role") Role role) {
		ModelAndView mv = new ModelAndView();
		role = roleService.selectByPrimaryKey(role.getRoleId());
		mv.addObject("role", role);
		mv.setViewName("role/assign");
		return mv;
	}
	
	
	/**
	 * 通过角色id获取用户列表
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/selectUserByRoleId", method = RequestMethod.GET)
	public @ResponseBody
	Pagination<User> selectUserByRoleId(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		user.setPageParameter(getpagePageParameter());
		Pagination<User> pagination = userService.selectByRoleIdPage(user);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
	
	/**
	 * 角色分配用户
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/roleManager/{id}", method = RequestMethod.GET)
	public ModelAndView roleManager(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Role role = roleService.selectByPrimaryKey(id);
		List<Dept> deptList = deptService.selectDepts();
		
		User user=new User();
		user.setRoleId(String.valueOf(id));
		List<User> userList=this.userService.selectByRoleIdNoPage(user);
		
	    StringBuilder sb = new StringBuilder();  
		    if (userList != null && userList.size() > 0) {  
		        for (int i = 0; i < userList.size(); i++) {  
		            if (i < userList.size() - 1) {  
		                sb.append(userList.get(i).getUserId() + ",");  
		            } else {  
		                sb.append(userList.get(i).getUserId());  
		            }  
		        }  
		    }  
		mv.addObject("selectIds", sb.toString());
        
		mv.addObject("userList", userList);
		mv.addObject("role", role);
		mv.addObject("deptList", deptList);
		mv.setViewName("role/selectUserToRole");
		return mv;
	}
	
	
	/**
	 * 根据部门获取用户
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/loadHasNotAssignedRoleUsers")
	@ResponseBody
	public List<ZTreeNode> loadHasNotAssignedRoleUsers( HttpServletRequest request) {

		String deptId=request.getParameter("deptId");
		User user=new User();
		user.setDeptId(deptId);
		List<User> userList=this.userService.selectUsers(user);
		
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(userList.size());
		for (User newuser : userList) {
			ZTreeNode node = new ZTreeNode();
			node.setId(String.valueOf(newuser.getUserId()));
			node.setName(newuser.getName());
			node.setOpen(true);
			node.setIsParent("false");
			node.setHasUser(false);
			nodeList.add(node);
		}
		return nodeList;
	}
	
}
