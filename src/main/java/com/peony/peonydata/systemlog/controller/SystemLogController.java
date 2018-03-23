package com.peony.peonydata.systemlog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.systemlog.model.SystemLog;
import com.peony.peonydata.systemlog.service.SystemLogService;
@Controller
@RequestMapping("/systemlog")
public class SystemLogController extends BaseController {

	@Autowired
	private SystemLogService systemLogService; // 系统日志服务
	

	/**
	 * 跳转到列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/systemLogList")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("systemlog/list_systemlog");
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
	 public Pagination<SystemLog> selectByPage(@ModelAttribute("systemLog") SystemLog systemLog,
			HttpServletRequest request) {
		systemLog.setPageParameter(getpagePageParameter());
		Pagination<SystemLog> pagination = this.systemLogService.selectByPage(systemLog);
		request.setAttribute("list", pagination);
		return pagination;
	}
}
