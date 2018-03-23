package com.peony.peonydata.customer.controller;

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
import com.peony.peonydata.agent.model.Agent;
import com.peony.peonydata.agent.service.AgentService;
import com.peony.peonydata.baseclass.model.BaseClass;
import com.peony.peonydata.baseclass.service.BaseClassService;
import com.peony.peonydata.customer.service.CustomerService;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.region.model.Region;
import com.peony.peonydata.region.service.RegionService;
import com.peony.peonydata.seller.service.SellerService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;
import com.peony.peonydata.userRegion.model.UserRegion;
import com.peony.peonydata.userbaseclass.model.UserBaseClass;
import com.peony.peonydata.util.encrypt.MD5;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {

	@Autowired
	private CustomerService customerService; // 客户服务接口
	@Autowired
	private IdService idService; // id服务接口

	@Autowired
	private UserService userService; // 用户服务接口

	@Autowired
	private AgentService agentService; // 代理商服务接口

	@Autowired
	private BaseClassService baseClassService; // 基础关键字类别服务接口

	@Autowired
	private RegionService regionService; // 地域服务接口

	@Autowired
	private SellerService sellerService; // 市场用户管理关系服务接口

	private static final String CustomerType = "2";// 客户标识
	private static final String MarketPersonType = "1";// 市场人员标识

	/**
	 * 跳转到客户列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView userList(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		user.setPersonType(MarketPersonType);
		List<User> list = this.userService.selectUsers(user);

		List<Agent> listAgent = this.agentService.selectAgents(new Agent());

		mv.addObject("list", list);
		mv.addObject("listAgent", listAgent);
		mv.setViewName("customer/list_user");
		return mv;
	}

	/**
	 * 管理员查看客户列表 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectByPage", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<User> selectByPage(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		User operate = (User) request.getSession().getAttribute("userModel");
		user.setCreateUserId(operate.getUserId());
		user.setPersonType(CustomerType);
		user.setPageParameter(getpagePageParameter());
		user.setOrderFields(request.getParameter("orderFields"));
		user.setOrder(request.getParameter("order"));
		Pagination<User> pagination = this.userService.selectByPage(user);
		request.setAttribute("list", pagination);
		return pagination;
	}

	/**
	 * 跳转到客户列表 all
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/allUserList", method = RequestMethod.GET)
	public ModelAndView allUserList(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		user.setPersonType(MarketPersonType);
		List<User> list = this.userService.selectUsers(user);

		List<Agent> listAgent = this.agentService.selectAgents(new Agent());

		mv.addObject("list", list);
		mv.addObject("listAgent", listAgent);
		mv.setViewName("customer/list_all_user");
		return mv;
	}

	/**
	 * 管理员查看客户列表 all
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectAllByPage", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<User> selectAllByPage(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		user.setPersonType(CustomerType);
		user.setPageParameter(getpagePageParameter());
		user.setOrderFields(request.getParameter("orderFields"));
		user.setOrder(request.getParameter("order"));
		Pagination<User> pagination = this.userService.selectByPage(user);
		request.setAttribute("list", pagination);
		return pagination;
	}

	/**
	 * 业务人员查看客户列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/marketSeeUserList", method = RequestMethod.GET)
	public ModelAndView marketSeeUserList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		User marketuser = (User) request.getSession().getAttribute("userModel");
		// 获取当前市场用户下所管辖的市场用户
		List<User> list = this.userService.selectByManagerId(marketuser
				.getUserId());

		mv.addObject("list", list);
		mv.setViewName("customer/list_customerUser");
		return mv;
	}

	/**
	 * 业务人员查看客户列表 帶分页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectFromMarketByPage", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<User> selectFromMarketByPage(
			@ModelAttribute("user") User user, HttpServletRequest request) {

		user.setPersonType(CustomerType);
		user.setPageParameter(getpagePageParameter());

		User marketuser = (User) request.getSession().getAttribute("userModel");

		if (user.getUserIds() == null || "".equals(user.getUserIds())) {
			// 获取当前市场用户下所管辖的市场用户
			List<User> list = this.userService.selectByManagerId(marketuser
					.getUserId());
			String userIds = listToString(list);
			user.setUserIds(userIds); // 将所管辖的市场用户填入

		}
		Pagination<User> pagination = this.userService.selectByPage(user);
		request.setAttribute("list", pagination);

		return pagination;
	}

	/**
	 * 添加客户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		user.setPersonType(MarketPersonType);
		List<User> userList = this.userService.selectUsers(user);

		mv.addObject("userList", userList);
		mv.setViewName("customer/add_customer");
		return mv;
	}

	/**
	 * 保存客户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	@ResponseBody
	public String saveUser(@ModelAttribute("user") User user,
			@ModelAttribute("userRegion") UserRegion userRegion,
			@ModelAttribute("userBaseClass") UserBaseClass userBaseClass,
			HttpServletRequest request) {
		user.setCreateTime(new Date());
		user.setPassword(MD5.passwordEncrypt(user.getPassword()));
		User operateUser = (User) request.getSession()
				.getAttribute("userModel");
		user.setCreateUser(operateUser.getName());
		user.setCreateUserId(operateUser.getUserId());

		int userId = idService.NextKey("user_id");// 先生成userId
		user.setUserId(userId);
		userBaseClass.setUserId(userId);
		userRegion.setUserId(userId);
		this.customerService.insertSelective(user, userBaseClass, userRegion);
		return "";
	}

	/**
	 * 通过销售人员来查询代理商 ajax
	 * 
	 * @param agent
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/agentList", method = RequestMethod.GET)
	@ResponseBody
	public List<Agent> agentList(@ModelAttribute("agent") Agent agent,
			HttpServletRequest request) {
		List<Agent> list = this.agentService.selectByUserId(agent.getUserId());
		return list;

	}

	/**
	 * 查询所有代理商
	 * 
	 * @param agent
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/agentAllList", method = RequestMethod.GET)
	@ResponseBody
	public List<Agent> agentAllList(@ModelAttribute("agent") Agent agent,
			HttpServletRequest request) {
		List<Agent> list = this.agentService.selectAgents(agent);
		return list;
	}

	/**
	 * 查询词库分类 ajax
	 * 
	 * @param agent
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/baseclassList/{parentCode}", method = RequestMethod.GET)
	@ResponseBody
	public List<BaseClass> baseclassList(@PathVariable String parentCode) {

		List<BaseClass> list = this.baseClassService.findChildren(parentCode);
		return list;

	}

	// selectRegion
	@RequestMapping(value = "/selectRegion", method = RequestMethod.GET)
	public ModelAndView selectRegion() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer/region_tree");
		return mv;
	}

	/**
	 * 编辑客户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		User u = new User();
		u.setPersonType(MarketPersonType);
		List<User> userList = this.userService.selectUsers(u);

		BaseClass bc = new BaseClass();
		List<BaseClass> baseClassList = this.baseClassService
				.selectBaseClassByUserId(id);
		if (baseClassList.size() > 0) {
			bc = baseClassList.get(0);
		}

		Region r = new Region();
		List<Region> regionList = this.regionService.selectByUserId(id);
		if (regionList.size() > 0) {
			r = regionList.get(0);
		}

		User user = userService.selectByPrimaryKey(id);
		user.setPassword(MD5.passwordDecrypt(user.getPassword()));

		mv.addObject("user", user);
		mv.addObject("userList", userList);
		mv.addObject("baseClass", bc);
		mv.addObject("region", r);
		mv.setViewName("customer/edit_customer");
		return mv;
	}

	/**
	 * 保存客户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(@ModelAttribute("user") User user,
			@ModelAttribute("userRegion") UserRegion userRegion,
			@ModelAttribute("userBaseClass") UserBaseClass userBaseClass,
			HttpServletRequest request) {
		user.setPassword(MD5.passwordEncrypt(user.getPassword()));
		User operateUser = (User) request.getSession()
				.getAttribute("userModel");
		user.setCreateUser(operateUser.getName());
		this.customerService.updateSelective(user, userBaseClass, userRegion);
		return "";
	}

	/**
	 * 删除客户
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public String deleteUser(
			@RequestParam(value = "ids", required = true) String ids,
			HttpServletRequest request) {
		this.userService.deleteByPrimaryKey(ids);
		return "";
	}

	/**
	 * 将用户列表中用户id 转化为‘，’号分隔字符串
	 * 
	 * @param list
	 * @return
	 */
	public static String listToString(List<User> list) {
		StringBuilder sb = new StringBuilder();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (i < list.size() - 1) {
					sb.append(list.get(i).getUserId() + ",");
				} else {
					sb.append(list.get(i).getUserId());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 跳转到客户列表(免费移动端)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/allEMobileUserList", method = RequestMethod.GET)
	public ModelAndView allEMobileUserList(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		user.setPersonType(MarketPersonType);
		List<User> list = this.userService.selectUsers(user);

		List<Agent> listAgent = this.agentService
				.selectMobileAgents(new Agent());

		mv.addObject("list", list);
		mv.addObject("listAgent", listAgent);
		mv.setViewName("customer/list_mobile_allUser");
		return mv;
	}

	/**
	 * 管理员查看客户列表 帶分页(免费移动版)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectMobileByPage", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<User> selectMobileByPage(
			@ModelAttribute("user") User user, HttpServletRequest request) {
		user.setPageParameter(getpagePageParameter());
		Pagination<User> pagination = this.customerService
				.selectMobileByPage(user);
		request.setAttribute("list", pagination);
		return pagination;
	}
}
