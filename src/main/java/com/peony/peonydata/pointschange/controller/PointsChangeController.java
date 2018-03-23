package com.peony.peonydata.pointschange.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.agent.model.Agent;
import com.peony.peonydata.agent.service.AgentService;
import com.peony.peonydata.pointschange.model.PointsChange;
import com.peony.peonydata.pointschange.service.PointsChangeService;
import com.peony.peonydata.pointsexchange.model.PointsExchange;
/**
 * 积分变更明细
 * @author zhyz
 *
 */
@Controller
@RequestMapping("/pointschange")
public class PointsChangeController extends BaseController{
	@Autowired
	private AgentService agentService; // 代理商服务接口
	@Autowired
	private PointsChangeService pointsChangeService;
	/**
	 * 跳转到积分明显列表页面
	 * @return
	 */
	@RequestMapping(value = "/pointschangeList")
	public ModelAndView getPointsChangeControllerList(){
		ModelAndView mv = new ModelAndView();
		 List <Agent> listAgent=this.agentService.selectMobileAgents(new Agent());
		 mv.addObject("listAgent", listAgent);
		mv.setViewName("pointschange/list_pointschange");
		return mv;
	}
	/**
	 * 查询积分明显（分页）
	 * @param pointsChange
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/selectPointsChangeListByPage", method = RequestMethod.GET)
	@ResponseBody
	public  Pagination<PointsChange>selectByPage(@ModelAttribute("pointsChange") PointsChange pointsChange,HttpServletRequest request){
		pointsChange.setPageParameter(getpagePageParameter());
		Pagination<PointsChange> pagination=this.pointsChangeService.selectPointsChangesByPage(pointsChange);
		request.setAttribute("list", pagination);
		return pagination;
	}
}
