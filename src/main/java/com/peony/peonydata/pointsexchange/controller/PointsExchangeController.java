package com.peony.peonydata.pointsexchange.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.pointsexchange.model.PointsExchange;
import com.peony.peonydata.pointsexchange.service.PointsExchangeService;
/**
 * E人E本积分兑换表
 * @author zhyz
 *
 */
@Controller
@RequestMapping("/pointsexchange")
public class PointsExchangeController extends BaseController{
	@Autowired
	private PointsExchangeService pointsExchangeService;
	@Autowired
	private IdService idService; // id服务接口
	/**
	 * 积分兑换表列表
	 * @return
	 */
	@RequestMapping(value = "/pointsExchangeList")
	public ModelAndView pointsExchangeList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pointsExchange/list_pointsExchange");
		return mv;
	}
	/**
	 * 查询积分兑换列表分页
	 * @param pointsExchange
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	@ResponseBody
	public  Pagination<PointsExchange>selectByPage(@ModelAttribute("pointsExchange") PointsExchange pointsExchange,HttpServletRequest request){
		pointsExchange.setPageParameter(getpagePageParameter());
		Pagination<PointsExchange> pagination=pointsExchangeService.selectByPage(pointsExchange);
		request.setAttribute("list", pagination);
		return pagination;
	}
	/**
	 * 添加积分兑换
	 * @return
	 */
	@RequestMapping(value = "/addPointsexchange")
	public ModelAndView addPointsexchange(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pointsExchange/add_pointsExchange");
		return mv;
	}
	/**
	 * 保存新加积分兑换
	 * @param pointsExchange
	 * @return
	 */
	@RequestMapping(value = "/savePointsExchange")
	public@ResponseBody String savePointsExchange(@ModelAttribute("pointsExchange") PointsExchange pointsExchange){
		pointsExchange.setId(idService.NextKey("pointsExchange_id"));
		pointsExchangeService.insertSelective(pointsExchange);
		return "";
	}
	/**
	 * 弹出修改积分兑换窗口
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/editPointsexchange/{id}", method = RequestMethod.GET)
	public ModelAndView editPointsexchange(@PathVariable int id,HttpServletRequest request, HttpServletResponse response){
		PointsExchange pointsExchange=pointsExchangeService.selectByPrimaryKey(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("id",pointsExchange.getId());
		mv.addObject("points", String.valueOf(pointsExchange.getPoints()));
		mv.addObject("unitprice", String.valueOf(pointsExchange.getUnitprice()));
		mv.setViewName("pointsExchange/edit_pointsExchange");
		return mv;
	}
	/**
	 * 保存修改
	 * @param pointsExchange
	 * @return
	 */
	@RequestMapping(value = "/updatePointsexchange", method = RequestMethod.POST)
	public @ResponseBody String updatePointsexchange(@ModelAttribute("pointsexchange") PointsExchange pointsExchange){
		pointsExchangeService.updateByPrimaryKeySelective(pointsExchange);
		return "";
	}
	/**
	 * 删除积分兑换
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delPointsexchange", method = RequestMethod.POST)
	public @ResponseBody String delPointsexchange(@ModelAttribute("id") Integer id){
		pointsExchangeService.deleteByPrimaryKey(id);
		return "";
	}
}
