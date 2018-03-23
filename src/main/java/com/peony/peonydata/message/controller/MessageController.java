package com.peony.peonydata.message.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.message.model.Message;
import com.peony.peonydata.message.service.MessageService;

/**
 * 留言板
 * @authorjhj
 *
 */
@Controller
@RequestMapping("/message")
public class MessageController extends BaseController{

	@Autowired
	private MessageService messageService; 
	
	
	/**
	 * 跳转到列表页
	 * @param request
	 * @param response
	 * @return mv
	 */
	@RequestMapping(value = "/messageList")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("message/list_message");
		return mv;
		
	}
	/**
	 * 留言板分页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectByPage")
	@ResponseBody
	 public Pagination<Message> selectByPage(@ModelAttribute("message") Message message,
				HttpServletRequest request) {
		message.setPageParameter(getpagePageParameter());
		Pagination<Message> pagination = this.messageService.selectByPage(message);
		request.setAttribute("list", pagination);
		return pagination;
		
	}
	
	/**
	 * 删除留言
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteMessage")
	@ResponseBody
	public String deleteMessage(@RequestParam(value = "id", required = true) int id) {
		this.messageService.deleteByPrimaryKey(id);
		logger.info("delete message success !");
		return "";
	}
	
	
}
