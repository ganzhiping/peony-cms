package com.peony.peonydata.information.controller;

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
import com.peony.peonydata.information.model.Information;
import com.peony.peonydata.information.service.InformationService;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;

/**
 * 站内消息
 * @authorjhj
 *
 */
@Controller
@RequestMapping("/information")
public class InformationController extends BaseController{

	@Autowired
	private InformationService informationService; 
	@Autowired
	private IdService idService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 跳转到列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/informationList")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("information/list_information");
		return mv;
		
	}
	/**
	 * 站内消息列表  帶分页
	 * @param request
	 * @param response
	 * @return
	 */
	 @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	 @ResponseBody
	 public Pagination<Information> selectByPage(@ModelAttribute("information") Information information,
			HttpServletRequest request) {
		information.setPageParameter(getpagePageParameter());
		Pagination<Information> pagination = this.informationService.selectByPage(information);
		request.setAttribute("list", pagination);
		return pagination;
	}

	/**
	 * 跳转到 --增加站内消息 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addInformation", method = RequestMethod.GET)
	public ModelAndView addInformation(HttpServletRequest request) {
		
		//todo  添加站内消息时选择user  此处加入userlist
		List<User> userList=this.userService.selectUsers(new User());
		ModelAndView mv=new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("information/add_information");
		return mv;
	}

	/**
	 * 保存增加
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/saveInformation", method = { RequestMethod.POST })
	@ResponseBody
	public String saveInformation(HttpServletRequest request, Information information,HttpServletResponse response) {
		User userModel = (User) request.getSession().getAttribute("userModel");
		
		int id=this.idService.NextKey("information");
		information.setInformationId(id);
		information.setSendTime(new Date());
		information.setSendUser(userModel.getUserId());
		information.setSendUsername(userModel.getName());
		this.informationService.insert(information);
	    logger.info("insert information...");
		return "";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteInformation")
    @ResponseBody
	public String deleteInformation(@RequestParam(value = "id", required = true) int id) {
		this.informationService.deleteByPrimaryKey(id);
		logger.info("delete info success !");
		return "";
	}
	
	
}
