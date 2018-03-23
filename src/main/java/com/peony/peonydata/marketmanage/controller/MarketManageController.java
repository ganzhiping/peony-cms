package com.peony.peonydata.marketmanage.controller;

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
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.marketmanage.service.MarketManageService;
import com.peony.peonydata.seller.model.Seller;
import com.peony.peonydata.seller.service.SellerService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;
import com.peony.peonydata.util.encrypt.MD5;

/**
 * 市场用户管理
 * @author jhj
 */
@Controller
@RequestMapping("/marketmanage")
public class MarketManageController extends BaseController{
	
	private static final String MarketPersonType="1";//市场人员标识
	private static final String IsDelete="1";//删除标识
	@Autowired
	private MarketManageService marketManageService; // 市场用户服务接口
	
	@Autowired
	private SellerService sellerService; // 市场用户管理关系服务接口
	
	
	@Autowired
	private UserService userService; // 用户服务接口
	
	@Autowired
	private IdService idService; // id服务接口
	/**
	 * 跳转到申请列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/marketManageList")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("marketmanage/list_marketuser");
		return mv;
	}
	
	/**
	 * 分页  条件查询  
	 * @param request
	 * @param response
	 * @return
	 */
	 @RequestMapping(value = "/selectByPage", method = RequestMethod.POST)
	 @ResponseBody
	 public Pagination<User> selectByPage(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		user.setPersonType(MarketPersonType);
		user.setPageParameter(getpagePageParameter());
		Pagination<User> pagination = this.marketManageService.selectByPage(user);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
	 
	/**
	 * 市场用户查询
	 * @return
	 */
	 @RequestMapping(value = "/selectMarketList")
	 public ModelAndView selectMarketList() {
			ModelAndView mv=new ModelAndView();
			mv.setViewName("marketmanage/select_marketuser");
			return mv;
		}
	 
	 @RequestMapping(value = "/selectMarketByPage", method = RequestMethod.POST)
	 @ResponseBody
	 public Pagination<User> selectMarketByPage(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		user.setPersonType(MarketPersonType);
		user.setPageParameter(getpagePageParameter());
		Pagination<User> pagination = this.marketManageService.selectByPage(user);
		request.setAttribute("list", pagination);
		return pagination;
	}
    /** 
	 * 添加市场用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("marketmanage/add_marketuser");
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
		user.setCreateUserId(operateUser.getUserId());
		Seller seller=new Seller();
		seller.setManagerUserId(user.getUserId());
		seller.setUserId(user.getUserId());
		this.marketManageService.insertMarketUser(user, seller);
		return "";
	}
	/**
	 * 编辑市场人员
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		User user = userService.selectByPrimaryKey(id);
		user.setPassword(MD5.passwordDecrypt(user.getPassword()));
		mv.addObject("user", user);
		mv.setViewName("marketmanage/edit_marketuser");
		return mv;
	}
	
	/**
	 * 更新市场用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(@ModelAttribute("user") User user,HttpServletRequest request) {
		user.setPassword(MD5.passwordEncrypt(user.getPassword()));
		userService.updateByPrimaryKeySelective(user);
		return "";
	}
	
	/**
	 * 删除市场用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public @ResponseBody
	String deleteUser(@RequestParam(value = "id", required = true) int id) {
		User user=this.userService.selectByPrimaryKey(id);
		user.setIsDelete(IsDelete);
		userService.updateByPrimaryKeySelective(user);
		return "";
	}

	
	/**
	 * 加载用户管理权限
	 * @param userId
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findUserRoles/{id}", method = RequestMethod.GET)
	public ModelAndView findUserRoles(@PathVariable int id,HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		User user=new User();
		user.setPersonType(MarketPersonType);
		List<User> listMarketUser=this.userService.selectUsers(user);
		
		Seller seller=new Seller();
		seller.setManagerUserId(id);
		List<Seller> sellerList=this.sellerService.selectByManagerId(seller);
		
		mv.addObject("listMarketUser", listMarketUser);
		mv.addObject("sellerList", sellerList);
		mv.addObject("managerUserId", id);
		mv.setViewName("marketmanage/findUserRole");
		return mv;

	}
	
	
	/**
	 * 更新市场用户管理关联
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateUserRole")
	@ResponseBody
	public String updateUserRole(@ModelAttribute("seller") Seller seller) {
		this.sellerService.updateSeller(seller);
		return "";
	}
}
