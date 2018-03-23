package com.peony.peonydata.points.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.points.model.Points;
import com.peony.peonydata.points.service.PointsService;
import com.peony.peonydata.salescount.model.Records;
import com.peony.peonydata.userserve.model.UserServe;
@Controller
@RequestMapping("/points")
public class PointsController extends BaseController{
	@Autowired
	private PointsService pointsService;
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping(value = "/pointsList", method = RequestMethod.GET)
	public ModelAndView pointsList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("points/list_points");
		return mv;
	}
	/**
	 * 查询积分类型分页
	 * @param points
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/selectAllpoints", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Points> selectAllpoints(@ModelAttribute("points") Points points,
			HttpServletRequest request) {
		points.setPageParameter(getpagePageParameter());
		Pagination<Points> pagination = this.pointsService.selectAllByPage(points);
		request.setAttribute("list", pagination);
		 return pagination;
	}
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping(value = "/toEdit/{id}", method = RequestMethod.GET)
	public ModelAndView toEdit(@PathVariable int id,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Points points=this.pointsService.selectByPrimaryKey(id);
		mv.addObject("points", points);
		mv.addObject("price", String.valueOf(points.getPoints()));
		mv.setViewName("points/edit_points");
		return mv;
	}
	/**
	 * 修改积分
	 * @param points
	 * @return
	 */
	@RequestMapping(value = "/editPoints", method = RequestMethod.POST)
	@ResponseBody
	public String editPoints(@ModelAttribute("points") Points points) {
		this.pointsService.updateByPrimaryKeySelective(points);
		return "";
	}
	
}
