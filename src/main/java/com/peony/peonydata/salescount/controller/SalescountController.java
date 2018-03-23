package com.peony.peonydata.salescount.controller;

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
import com.peony.peonydata.combo.model.Combo;
import com.peony.peonydata.combo.service.ComboService;
import com.peony.peonydata.salescount.model.Records;
import com.peony.peonydata.salescount.service.SalescountService;
import com.peony.peonydata.user.model.User;

@Controller
@RequestMapping("/salescount")
public class SalescountController extends BaseController{
	@Autowired
	private AgentService agentService; // 代理商服务接口
	@Autowired
	private SalescountService salescountService;
	@Autowired
	private ComboService comboService;
	/**
	 * 销售统计
	 * @return
	 */
	@RequestMapping(value = "/selectSalescount", method = RequestMethod.GET)
	public ModelAndView selectAllMobileSales() {
		ModelAndView mv = new ModelAndView();
		 List <Agent> listAgent=this.agentService.selectMobileAgents(new Agent());
		 List<Combo> comboList=this.comboService.selectAllCombos();
		 mv.addObject("listAgent", listAgent);
		 mv.addObject("comboList", comboList);
		mv.setViewName("salescount/list_selectSalescount");
		return mv;
	}
	/**
	 * 查询消费明细，按套餐分组
	 * @return
	 */
	@RequestMapping(value = "/selectAllMobileSalesCountList", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Records> selectAllMobileSalesCountList(@ModelAttribute("records") Records records,
			HttpServletRequest request) {
		records.setPageParameter(getpagePageParameter());
		Pagination<Records> pagination = this.salescountService.selectSalesCountByPage(records);
		request.setAttribute("list", pagination);
		 return pagination;
	}
	/**
	 * 点击套餐
	 * @return
	 */
	@RequestMapping(value = "/selectMobileSalesCountListByComboidId", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView selectMobileSalesCountListByComboidId(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		 List <Agent> listAgent=this.agentService.selectMobileAgents(new Agent());
		 mv.addObject("comboid", request.getParameter("comboid"));
		 mv.addObject("listAgent", listAgent);
		mv.setViewName("salescount/list_selectSalescountByComboidId");
		return mv;
	}
	/**
	 * 查看具体套餐下的消费明细
	 * @return
	 */
	@RequestMapping(value = "/selectAllMobileSalesCountListByComboid", method = RequestMethod.POST)
	@ResponseBody
	public  Pagination<Records> selectAllMobileSalesCountListByComboid(@ModelAttribute("records") Records records,
			HttpServletRequest request) {
		records.setPageParameter(getpagePageParameter());
		Pagination<Records> pagination =this.salescountService.selectSalesCountByComboidByPage(records);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
}
