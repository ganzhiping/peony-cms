package com.peony.peonydata.feedback.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.peony.peonydata.feedback.model.Feedback;
import com.peony.peonydata.feedback.service.FeedbackService;

/**
 * 问题反馈
 * @authorjhj
 *
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController extends BaseController{

	@Autowired
	private FeedbackService feedbackService; 
	
	
	/**
	 * 跳转到问题反馈列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/feedbackList")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("feedback/list_feedback");
		return mv;
	}
	
	/**
	 * 反馈列表  帶分页
	 * @param request
	 * @param response
	 * @return
	 */
	 @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	 @ResponseBody
	 public Pagination<Feedback> selectByPage(@ModelAttribute("feedback") Feedback feedback,
			HttpServletRequest request) {
		feedback.setPageParameter(getpagePageParameter());
		Pagination<Feedback> pagination = this.feedbackService.selectByPage(feedback);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteFeedback")
	@ResponseBody
	public String deleteFeedback(@RequestParam(value = "id", required = true) String ids) {
		String [] array=ids.split(",");
		for(String id:array){
			this.feedbackService.deleteByPrimaryKey(Integer.valueOf(id));
			logger.info("delete feedback success !");
		}
		return "";
	}
	
	
}
