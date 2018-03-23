package com.peony.peonydata.operationlog.controller;

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
import com.peony.peonydata.agent.model.Agent;
import com.peony.peonydata.agent.service.AgentService;
import com.peony.peonydata.operationlog.model.EbOperation;
import com.peony.peonydata.operationlog.model.OperationLog;
import com.peony.peonydata.operationlog.service.EbOperationService;
import com.peony.peonydata.operationlog.service.OperationLogService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;

/**
 * 操作日志
 * @authorjhj
 */
@Controller
@RequestMapping("/operationlog")
public class OperationLogController extends BaseController{

	@Autowired
	private OperationLogService operationLogService; 
	
	@Autowired
	private EbOperationService ebOperationService; 
	
	@Autowired
	private UserService userService; // 用户服务接口
	
	
	@Autowired
	private AgentService agentService;//代理商服务接口
	
	/**
	 * 跳转到申请列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/operationLogList")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		User user=new User();
		user.setPersonType("2");
		List<User> userList=this.userService.selectUsers(user);
		mv.addObject("userList", userList);
		mv.setViewName("operationlog/list_operationlog");
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
	 public Pagination<OperationLog> selectByPage(@ModelAttribute("operationLog") OperationLog operationLog,
			HttpServletRequest request) {
		operationLog.setPageParameter(getpagePageParameter());
		Pagination<OperationLog> pagination = this.operationLogService.selectByPage(operationLog);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
	
	/**
	 * 登录  操作模块儿 统计图 跳转
	 * @return mv
	 */
	@RequestMapping(value = "/selectOperationLogsCounts")
	public ModelAndView selectOperationLogsCounts() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("operationlog/count_operationlog");
		return mv;
	}
	
	/**
	 * ajax 登录日志统计
	 * @return map
	 */
	@RequestMapping(value = "/selectOperationLoginLogsByajax", method = { RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> selectOperationLoginLogsByajax() {
		Map<String, Object> mapModel = Maps.newHashMap();
		List<OperationLog> loginCountList=this.operationLogService.selectOperationLogsByLoginCounts();
	
		mapModel.put("loginCountList", loginCountList);
		return mapModel;
	}
	
	
	/**
	 * ajax 模块儿点击统计
	 * @return map
	 */
	@RequestMapping(value = "/selectOperationModuleLogsByajax", method = { RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> selectOperationModuleLogsByajax() {
		Map<String, Object> mapModel = Maps.newHashMap();
		List<OperationLog> moduleCountList=this.operationLogService.selectOperationLogsByModuleCounts();
	
		mapModel.put("moduleCountList", moduleCountList);
		return mapModel;
	}
	/**
	 * E人E本用户登录统计
	 * @return
	 */
	@RequestMapping(value = "/selectEbookOperationLoginLogsByajax", method = { RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> selectEbookOperationLoginLogsByajax() {
		Map<String, Object> mapModel = Maps.newHashMap();
		List<OperationLog> moduleCountList=this.operationLogService.selectEbookOperationLoginLogsByajax();
	
		mapModel.put("moduleCountList", moduleCountList);
		return mapModel;
	}
	/**
	 * E人E本热点新闻点击数统计
	 * @return
	 */
	@RequestMapping(value = "/selectEbookOperationHotNewsLogsByajax", method = { RequestMethod.POST})
	@ResponseBody
	public Map<String,Object> selectEbookOperationHotNewsLogsByajax() {
		Map<String, Object> mapModel = Maps.newHashMap();
		List<OperationLog> moduleCountList=this.operationLogService.selectEbookOperationHotNewsLogsByajax();
		
		mapModel.put("moduleCountList", moduleCountList);
		return mapModel;
	}
	
	/**
	 * 跳转到eb日志列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/eboperationLogList")
	public ModelAndView eblist() {
		ModelAndView mv=new ModelAndView();
		Agent agent=new Agent();
		List<Agent> agentList=this.agentService.selectMobileAgents(agent);
		
		mv.addObject("agentList", agentList);
		mv.setViewName("operationlog/list_eboperationlog");
		return mv;
	}
	
	/**
	 * 分页  条件查询  eb日志列表页
	 * @param request
	 * @param response
	 * @return
	 */
	 @RequestMapping(value = "/selectebByPage", method = RequestMethod.GET)
	 @ResponseBody
	 public Pagination<EbOperation> selectebByPage(@ModelAttribute("ebOperation") EbOperation ebOperation,
			HttpServletRequest request) {
		ebOperation.setPageParameter(getpagePageParameter());
		Pagination<EbOperation> pagination = this.ebOperationService.selectByPage(ebOperation);
		request.setAttribute("list", pagination);
		return pagination;
	}
	 
	@RequestMapping(value = "/ebInfoList")
	public ModelAndView ebInfoList() {
			ModelAndView mv=new ModelAndView();
			Agent agent=new Agent();
			List<Agent> agentList=this.agentService.selectMobileAgents(agent);
			
			mv.addObject("agentList", agentList);
			mv.setViewName("operationlog/list_eb_infolog");
			return mv;
	 	}
	 
	 @RequestMapping(value = "/selectebInfoByPage", method = RequestMethod.GET)
	 @ResponseBody
	 public Pagination<EbOperation> selectebInfoByPage(@ModelAttribute("ebOperation") EbOperation ebOperation,
			HttpServletRequest request) {
		ebOperation.setPageParameter(getpagePageParameter());
		Pagination<EbOperation> pagination = this.ebOperationService.selectByPage(ebOperation);
		request.setAttribute("list", pagination);
		return pagination;
	}
}
