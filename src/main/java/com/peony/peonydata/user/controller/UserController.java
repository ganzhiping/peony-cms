package com.peony.peonydata.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.dept.model.Dept;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.dept.service.DeptService;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.menu.model.Menu;
import com.peony.peonydata.menu.service.MenuService;
import com.peony.peonydata.region.model.Region;
import com.peony.peonydata.region.service.RegionService;
import com.peony.peonydata.role.model.Role;
import com.peony.peonydata.role.service.RoleService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;
import com.peony.peonydata.util.JSONUtil;
import com.peony.peonydata.util.MenuComparator;
import com.peony.peonydata.util.encrypt.MD5;

/**
 * demo controller
 * 
 * @date 2013-10-24 下午05:38:49
 * @author zhaoshutao
 * @version 1
 */

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService; // 用户服务接口
	@Autowired
	private IdService idService; // id服务接口
	@Autowired
	private DeptService deptService; // 部门服务接口
	@Autowired
	private RoleService roleService; // 角色服务接口
	@Autowired
	private MenuService menuService; // 菜单服务接口
	
	@Autowired
	private RegionService regionService; // 菜单服务接口

	/**
	 * 查询全部用户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView userList() {
		ModelAndView mv = new ModelAndView();
		List<Dept> deptList = deptService.selectDepts();
		List<ZTreeNode> nodes = DeptNodeList(deptList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));

		mv.setViewName("user/list_user");
		return mv;
	}

	/**
	 * 根据id加载用户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loadUser/{id}", method = RequestMethod.GET)
	public ModelAndView loadUser(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		// int usid = idService.getNextKey("user_id");
		User user = userService.selectByPrimaryKey(id);
		request.setAttribute("user", user);

		return new ModelAndView("user/user_info");
	}

	/**
	 * 查询全部用户 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	@ResponseBody
	public 
	Pagination<User> selectByPage(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		user.setPageParameter(getpagePageParameter());
		user.setOrderFields(request.getParameter("orderFields"));
		user.setOrder(request.getParameter("order"));
		Pagination<User> pagination = userService.selectByPage(user);
		request.setAttribute("list", pagination);
		return pagination;
	}

	/**
	 * 查询全部用户 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Dept> deptList = deptService.selectDepts();
		List<ZTreeNode> nodes = DeptNodeList(deptList, "");
		User user = userService.selectByPrimaryKey(id);
		Dept dt=null;
		for(Dept dept:deptList){
			if(user.getDeptId().equals(String.valueOf(dept.getDeptId()))){
				dt=dept;break;
			}
		}
		
		
		
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.addObject("user", user);
		mv.addObject("dept", dt);
		mv.setViewName("user/edit_user");
		return mv;
	}

	/**
	 * 更新用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(@ModelAttribute("user") User user,HttpServletRequest request) {
		userService.updateByPrimaryKeySelective(user);
		return "";
	}

	/**
	 * 查询全部用户 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		List<Dept> deptList = deptService.selectDepts();
		List<ZTreeNode> nodes = DeptNodeList(deptList, "");
		
		
		
		List<Region> regionList = regionService.selectRegions(new Region());
		List<ZTreeNode> regionNodes = RegionNodeList(regionList, "");
		
		mv.addObject("regionNodeList", JSONUtil.array2JSON2(regionNodes.toArray()));
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("user/add_user");
		return mv;
	}

	/**
	 * 保存用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public @ResponseBody
	String saveUser(@ModelAttribute("user") User user,HttpServletRequest request) {
		user.setUserId(idService.NextKey("user_id"));
		user.setCreateTime(new Date());
		user.setPassword(MD5.passwordEncrypt(user.getPassword()));
		User operateUser=(User)request.getSession().getAttribute("userModel");
		user.setCreateUser(operateUser.getName());
		userService.insertSelective(user);
		return "";
	}

	/**
	 * 查询全部用户 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public @ResponseBody
	String deleteUser(@RequestParam(value = "id", required = true) int id) {
		User user=this.userService.selectByPrimaryKey(id);
		user.setIsDelete("1");
		userService.updateByPrimaryKeySelective(user);
		return "";
	}

	/**
	 * 个人信息修改页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/editUserInfo", method = RequestMethod.GET)
	public ModelAndView editUserInfo(HttpServletRequest request,
			HttpServletResponse response) {

		User userModel = (User) request.getSession().getAttribute("userModel");
		if (userModel != null) {
			request.setAttribute("user", userModel);
			return new ModelAndView("user/user_info");
		} else {
			return new ModelAndView("user/login");
		}

	}

	/**
	 * 保存个人信息修改
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public String updateUserInfo(HttpServletRequest request,@ModelAttribute("user") User user,
			HttpServletResponse response) {
		User userModel = (User) request.getSession().getAttribute("userModel");
		if (userModel != null) {
//			user.setCreateUser(userModel.getName());
			this.userService.updateByPrimaryKeySelective(user);
			User newuser=this.userService.selectByPrimaryKey(userModel.getUserId());
			request.getSession().setAttribute("userModel", newuser);
			logger.info("editUserInfo success !");
		} 
		return "";
	}

	/**
	 * 修改密码页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/editPwd", method = RequestMethod.GET)
	public ModelAndView modifyPwd(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		User userModel = (User) request.getSession().getAttribute("userModel");
		if (userModel != null) {
			mv.addObject("user", userModel);
			mv.setViewName("user/edit_password");

		} else {
			mv.setViewName("user/login");// 登录
		}
		return mv;
	}

	/**
	 * @throws ServletRequestBindingException
	 *             修改密码信息
	 * 
	 * @param request
	 * @param resModel
	 * @return
	 * @throws
	 */
	@RequestMapping(value = "/updatePassword", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String,Object> updatePassword(HttpServletRequest request)
			throws ServletRequestBindingException {

		String oldPassword = ServletRequestUtils.getStringParameter(request,
				"oldPassword"); // 旧密码
		String newPassword = ServletRequestUtils.getStringParameter(request,
				"newPassword");// 新密码

		HashMap mapModel=Maps.newHashMap();
		// 检查session中是否有此用户
		User userModel = (User) request.getSession().getAttribute("userModel");

		if (userModel != null) {
			String encryptPassword = MD5.passwordEncrypt(oldPassword);
			if (userModel.getPassword().equals(encryptPassword)) {
				userModel.setPassword(MD5.passwordEncrypt(newPassword));
				this.userService.updateByPrimaryKeySelective(userModel);
				request.getSession().setAttribute("userModel", userModel);
				mapModel.put("status", "1");
			}else{
				mapModel.put("status", "2");
			}
		} else {
			mapModel.put("status", "0");
		}

		return mapModel;
	}
	
	
	/**
	 * 用户名检查
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/checkLoginName", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> checkLoginName(@ModelAttribute("user") User user) {
		HashMap mapModel=Maps.newHashMap();
		String loginName=user.getLoginName();
		if (loginName != null && !"".equals(loginName.trim())) {
			User newuser=new User();
			newuser.setLoginName(loginName);
			List<User> list=this.userService.selectUsers(newuser);
			if(list.size()>0){
				mapModel.put("status", 0);//有此用户名
			}else{
				mapModel.put("status", 1);
			}
		} 
		return mapModel;
	}

	
	/**
	 * 跳转到登陆页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login");
		return mv;
	}
	
	
	/**
	 * 跳转到主页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		User user=(User)request.getSession().getAttribute("userModel");
		mv.addObject("user", user);
		mv.setViewName("index/index");
		return mv;

	}
	
	
	/**
	 * ajax加载后台左侧菜单
	 * @param request
	 * @param menus
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/module", method = RequestMethod.POST)
	@ResponseBody
	public List module(HttpServletRequest request,Menu menus,
			HttpServletResponse response) {
		List<Menu> allMenuSetList = (List)request.getSession().getAttribute("menuListSession");
		TreeSet<Menu> leftmenuSet = new TreeSet(new MenuComparator());
		List<Menu> menuList=this.menuService.selectByMenuCode(menus);
		if(menuList.size()>0){
			menuList.remove(0);
			leftmenuSet.addAll(menuList);
		}
		List leftMenuSetList=new ArrayList();
		leftmenuSet.retainAll(allMenuSetList);
		for(Iterator<Menu> iterator = leftmenuSet.iterator();iterator.hasNext();)
		{  
			leftMenuSetList.add(iterator.next());
        }  
		
		return leftMenuSetList;
	}
	/**
	 * 登录检查
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loginCheck",method = RequestMethod.POST)
	@ResponseBody
	public String loginCheck(@ModelAttribute("user") User user, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String loginName=request.getParameter("loginName");
		String password=request.getParameter("password");
		request.getSession().setAttribute("userModel", null);// 用户信息
		
		
		List <Menu> menuSetList=new ArrayList();
		List <Menu> leftmenuSetList=new ArrayList();
		List <Menu> allMenuList=new ArrayList();
		
		if (loginName != null && !"".equals(loginName)
				&& password != null && !"".equals(password)) {

			String encryptPassword = MD5.passwordEncrypt(password);// 密码加密
			List<User> list = this.userService.selectUserByLoginName(loginName);
			if (list.size() > 0) {
				User u = list.get(0);
				if (encryptPassword.equalsIgnoreCase(u.getPassword())) {
					request.getSession().setAttribute("userModel", u);// 用户信息
					
					List<Role> roleList=this.roleService.selectByUserId(u.getUserId());
					TreeSet<Menu> menuSet = new TreeSet(new MenuComparator());
					TreeSet<Menu> allMenuSet = new TreeSet(new MenuComparator());
					if(roleList.size()>0){
					for(Role newrole:roleList){
						List<Menu> menuList=this.menuService.selectByRoleId(newrole.getRoleId());
						allMenuSet.addAll(menuList);
						for(Menu menu:menuList){
							String code=menu.getIdentify();
							if(code.substring(0,code.length()-3).equals("10")){//权限标识字段 左移三位==10的写入后台menuset   前台则为==20的
								menuSet.add(menu);
							}
							
							
						}
						
					}
				
					}
					Menu first=new Menu();
					if(!menuSet.isEmpty()){
						first=menuSet.first();//进入后台时默认加载第一个菜单的内容
					}else{
						first.setIdentify("-1");
					}
				
					/**--------------------**/
					TreeSet<Menu> leftmenuSet = new TreeSet(new MenuComparator());
					List<Menu> menuList=this.menuService.selectByMenuCode(first);
					if(menuList.size()>0){
						menuList.remove(0);
						leftmenuSet.addAll(menuList);
					}
					
					leftmenuSet.retainAll(allMenuSet);
					
					
					
					for(Iterator<Menu> iterator = menuSet.iterator();iterator.hasNext();)
					{  
						menuSetList.add(iterator.next());
			        } 
					
					request.getSession().setAttribute("backMenuSet", menuSetList);
					
					for(Iterator<Menu> iterator = leftmenuSet.iterator();iterator.hasNext();)
					{  
						leftmenuSetList.add(iterator.next());
			        }  
					request.getSession().setAttribute("leftMenuList", leftmenuSetList);
					
					for(Iterator<Menu> iterator = allMenuSet.iterator();iterator.hasNext();)
					{  
						allMenuList.add(iterator.next());
			        }  
					request.getSession().setAttribute("menuListSession", allMenuList);
					
					return "1";
				}
			} else {
				return "0";
			}

		} else {
			return "0";
		}

		return null;

	}

	/**
	 * 登出
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().setAttribute("userModel", null);
		request.getSession().setAttribute("menuListSession", null);
		request.getSession().setAttribute("leftMenuList", null);
		request.getSession().setAttribute("backMenuSet", null); 
		request.getSession().invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login");
		return mv;

	}

	/**
	 * 返回dept ztree列表
	 * 
	 * @param list
	 * @return
	 */
	public List<ZTreeNode> DeptNodeList(List<Dept> list, String checkid) {
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
	
	/**
	 * 返回region ztree列表
	 * @param list
	 * @return
	 */
	public List<ZTreeNode> RegionNodeList(List<Region> list, String checkid) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());
		String pid = "";
		for (Region region : list) {
			if (checkid.equals(String.valueOf(region.getRegionid()))) {
				pid = String.valueOf(region.getParentid());
				break;
			}
		}
		for (Region region : list) {
			ZTreeNode node = new ZTreeNode();
			if (pid.equals(String.valueOf(region.getRegionid()))) {
				node.setChecked(true);
			}
			node.setId(String.valueOf(region.getRegionid()));
			node.setPId(String.valueOf(region.getParentid()));
			node.setName(region.getRegionname());
			/*node.setIsParent(deptService.loadHasChildren(String.valueOf(dpt
					.getDeptId())) ? "true" : "false");*/
			nodeList.add(node);
		}
		return nodeList;

	}
	
	
	
	
	/**
	 * 用户配置权限
	 * @param userId
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findUserRoles/{id}", method = RequestMethod.GET)
	public ModelAndView findUserRoles(@PathVariable int id,HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Role> RoleList=this.roleService.selectByUserId(id);
		List<Role> allRoleList=this.roleService.selectRoles();
		
		mv.addObject("userId", id);//用户id
		mv.addObject("roleList", RoleList);//用户已有角色列表
		mv.addObject("allRoleList", allRoleList);//全部角色列表
		mv.setViewName("user/findUserRole");
		return mv;

	}
	
	
}
