package com.peony.peonydata.userserve.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;
import com.peony.peonydata.userserve.model.UserServe;
import com.peony.peonydata.userserve.service.UserServeService;

/**
 * 用户服务
 * @author jhj
 */
@Controller
@RequestMapping("/userservice")
public class UserServeController extends BaseController{

	@Autowired
	private UserServeService userServeService; // 用户服务接口
	
	@Autowired
	private UserService userService; // 用户接口
	
	@Autowired
	private IdService idService; // id服务接口

	/**
	 * 跳转到用户服务编辑页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/editUserService/{id}", method = RequestMethod.GET)
	public ModelAndView editUserService(@PathVariable int id,HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		User user=this.userService.selectByPrimaryKey(id);
		UserServe us=this.userServeService.selectByUserId(id);
		if(us==null){
			us=new UserServe();
		}
		mv.addObject("userService", us);
		mv.addObject("user",user);
		mv.addObject("userId",id);
		mv.setViewName("userservice/edit_userservice");
		return mv;
	}
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editMobileUserService/{id}", method = RequestMethod.GET)
	public ModelAndView editMobileUserService(@PathVariable int id,HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		User user=this.userService.selectByPrimaryKey(id);
		UserServe us=this.userServeService.selectByUserId(id);
		if(us==null){
			us=new UserServe();
		}
		mv.addObject("userService", us);
		mv.addObject("user",user);
		mv.addObject("userId",id);
		mv.setViewName("userservice/edit_mobile_userservice");
		return mv;
	}
	
	/**
	 * 更新用户服务
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updateUserService", method = RequestMethod.POST)
	@ResponseBody
	public String updateUserService(@ModelAttribute("userService") UserServe userService) {
		
		
		if(userService.getUserserviceId()!=null){
			int userServiceId=userService.getUserserviceId();
			UserServe us=this.userServeService.selectByPrimaryKey(userServiceId);
			if(us!=null){
				userServeService.updateByPrimaryKeySelective(userService);
			}
		}else{
			userService.setUserserviceId(idService.NextKey("userService_id"));
			this.userServeService.insertSelective(userService);
		}
		
		return "";
	}
	/**
	 * 更新用户服务(免费移动端)
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/updateMobileUserService", method = RequestMethod.POST)
	@ResponseBody
	public String updateMobileUserService(@ModelAttribute("userService") UserServe userService) {
		
		
		if(userService.getUserserviceId()!=null){
			int userServiceId=userService.getUserserviceId();
			UserServe us=this.userServeService.selectByPrimaryKey(userServiceId);
			if(us!=null){
				userServeService.updateMobileByPrimaryKeySelective(userService);
			}
		}else{
			userService.setUserserviceId(idService.NextKey("userService_id"));
			this.userServeService.insertMobileSelective(userService);
		}
		
		return "";
	}
	
}
