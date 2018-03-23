package com.peony.peonydata.ebinfolog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.ebinfolog.model.EbInfoLog;
import com.peony.peonydata.ebinfolog.service.EbInfoLogService;
/**
 * 信息日志
 * @throws
 */
@Controller
@RequestMapping("/ebinfolog")
public class EbInfoLogController extends BaseController{

	@Autowired
	private EbInfoLogService ebInfoLogService; 

	/**
	 * 跳转到申请列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ebInfoLogList")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ebinfolog/list_ebinfolog");
		return mv;
	}
	
	/**
	 * 跳转到申请图表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ebInfoLogCount")
	public ModelAndView ebInfoLogCount() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ebinfolog/count_ebinfolog");
		return mv;
	}
	
	/**
	 * 分页  条件查询  status
	 * @param request
	 * @param response
	 * @return
	 */
	 @RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	 @ResponseBody
	 public Pagination<EbInfoLog> selectByPage(@ModelAttribute("ebInfoLog") EbInfoLog ebInfoLog,
			HttpServletRequest request) {
		ebInfoLog.setPageParameter(getpagePageParameter());
		Pagination<EbInfoLog> pagination = this.ebInfoLogService.selectByPage(ebInfoLog);
		request.setAttribute("list", pagination);
		return pagination;
	}
	 
	 /**
      * 信息日志前十条点击转发收藏统计
	  * @return
	  */
	  @RequestMapping(value = "/selectEbInfoLogsByAjax", method = { RequestMethod.POST})
	  @ResponseBody
	  public Map<String,Object> selectEbookOperationLoginLogsByajax() {
		 Map<String, Object> mapModel = Maps.newHashMap();
		 List<EbInfoLog> ebInfoLogCountList=this.ebInfoLogService.selectEbInfoLogsByAjax();
		 mapModel.put("ebInfoLogCountList", ebInfoLogCountList);
		 return mapModel;
     }
	  
	  /**
	   * 信息来源统计
	   * @return
	   */
	  @RequestMapping(value = "/selectEbInfoLogsByAjaxAndType",method = { RequestMethod.POST})
	  @ResponseBody
	  public Map<String,Object> selectEbInfoLogsByAjaxAndType(){
		 Map<String, Object> mapModel = Maps.newHashMap();
		 List<EbInfoLog> ebInfoLogTypeCountList = this.ebInfoLogService.selectEbInfoLogsByAjaxAndType();
		 mapModel.put("ebInfoLogTypeCountList", ebInfoLogTypeCountList);
		 return mapModel;
	  } 
	  
	  /**
	    * 模块点击量统计
		* @return
		*/
	   @RequestMapping(value = "/selectEbInfoLogsByAjaxAndModule", method = { RequestMethod.POST})
	   @ResponseBody
	   public Map<String,Object> selectEbInfoLogsByAjaxAndModule() {
		  Map<String, Object> mapModel = Maps.newHashMap();
		  List<EbInfoLog> ebInfoLogModuleCountList=this.ebInfoLogService.selectEbInfoLogsByAjaxAndModule();
		  mapModel.put("ebInfoLogModuleCountList", ebInfoLogModuleCountList);
		  return mapModel;
	     }
	   
	  /**
	   * 模块转发收藏量统计
	   */
	   @RequestMapping(value ="/selectEbInfoLogsByAjaxAndModuleAndForwardsCollects",method = { RequestMethod.POST})
	   @ResponseBody
	   public Map<String,Object> selectEbInfoLogsByAjaxAndModuleAndForwardsCollects() {
		  Map<String, Object> mapModel = Maps.newHashMap();
		  List<EbInfoLog> enInfoLogMoudleForColCountList = this.ebInfoLogService.selectEbInfoLogsByAjaxAndModuleAndForwardsCollects();
		  mapModel.put("enInfoLogMoudleForColCountList", enInfoLogMoudleForColCountList);
		  return mapModel;
	   }
		  
}
