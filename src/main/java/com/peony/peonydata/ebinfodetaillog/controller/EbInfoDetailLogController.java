package com.peony.peonydata.ebinfodetaillog.controller;

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
import com.peony.peonydata.ebinfodetaillog.model.EbInfoDetailLog;
import com.peony.peonydata.ebinfodetaillog.service.EbInfoDetailLogService;

/**
 * 信息日志
 * 
 * @throws
 */
@Controller
@RequestMapping("/ebinfodetaillog") 
public class EbInfoDetailLogController extends BaseController {

	@Autowired
	private EbInfoDetailLogService ebInfoDetailLogService;

	/**
	 * 跳转到申请列表页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ebInfoDetailLogList")
	public ModelAndView list(
			@ModelAttribute("ebInfoDetailLog") EbInfoDetailLog ebInfoDetailLog,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("infoLogId", ebInfoDetailLog.getInfoLogId());
		mv.addObject("operationType", ebInfoDetailLog.getOperationType());
		mv.setViewName("ebinfodetaillog/list_ebinfodetaillog");
		return mv;
	}

	/**
	 * 分页 条件查询 status
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	@ResponseBody
	public Pagination<EbInfoDetailLog> selectByPage(
			@ModelAttribute("ebInfoDetailLog") EbInfoDetailLog ebInfoDetailLog,
			HttpServletRequest request) {
		ebInfoDetailLog.setPageParameter(getpagePageParameter());
		Pagination<EbInfoDetailLog> pagination = this.ebInfoDetailLogService
				.selectByPage(ebInfoDetailLog);
		request.setAttribute("list", pagination);
		return pagination;
	}
}
