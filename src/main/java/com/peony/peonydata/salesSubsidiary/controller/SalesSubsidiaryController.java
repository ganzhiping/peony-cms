package com.peony.peonydata.salesSubsidiary.controller;

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
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;


/**
 * 销售明细
 * @author zhyz
 *
 */
@Controller
@RequestMapping("/salesSubsidiary")
public class SalesSubsidiaryController extends BaseController{
	@Autowired
	private AgentService agentService; // 代理商服务接口
	@Autowired
	private ComboService comboService;
	@Autowired
	private UserService userService;
	/**
	 * 销售明细分页
	 * @return
	 */
	@RequestMapping(value = "/selectAllMobileSales", method = RequestMethod.GET)
	public ModelAndView selectAllMobileSales(@ModelAttribute("user") User user) {
		ModelAndView mv = new ModelAndView();
		 List <Agent> listAgent=this.agentService.selectMobileAgents(new Agent());
		 List<Combo> comboList=this.comboService.selectAllCombos();
		 Integer comboid=user.getComboId();
		 user=this.userService.selectByPrimaryKey(user.getUserId());
		 //从销售统计点击用户跳转到该用户消费明细页面
		 //套餐id不为空
		 if(comboid!=null){
		 user.setComboId(comboid);
		 }
		 mv.addObject("listAgent", listAgent);
		 mv.addObject("comboList", comboList);
		 mv.addObject("user", user);
		 mv.setViewName("salesSubsidiary/list_all_salesSubsidiary");
		 return mv;
	}
	/**
	 * 销售明细分页(列表)
	 * @return
	 */
	@RequestMapping(value = "/selectAllMobileSalesList", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<User> selectAllMobileSalesList(@ModelAttribute("user") User user,
			HttpServletRequest request) {
		user.setPageParameter(getpagePageParameter());
		Pagination<User> pagination = this.userService.selectAllMobileSalesListByPage(user);
		request.setAttribute("list", pagination);
		 return pagination;
	}
}
