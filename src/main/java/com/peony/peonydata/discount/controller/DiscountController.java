package com.peony.peonydata.discount.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.peony.peonydata.combo.model.Combo;
import com.peony.peonydata.combo.service.ComboService;
import com.peony.peonydata.discount.model.Discount;
import com.peony.peonydata.discount.service.DiscountService;
import com.peony.peonydata.key.service.IdService;

@Controller
@RequestMapping("/discount")
public class DiscountController extends BaseController{
	@Autowired
	private DiscountService discountService;
	@Autowired
	private ComboService comboService;
	@Autowired
	private IdService idService; // id服务接口
	/**
	 * 折扣列表页
	 * @return
	 */
	@RequestMapping(value = "/discountList", method = RequestMethod.GET)
	public ModelAndView discountList(){
		ModelAndView mv = new ModelAndView();
		//获取所有套餐列表
		List<Combo> comboList=this.comboService.selectComboList();
		mv.addObject("comboList", comboList);
		mv.setViewName("discount/list_discount");
		return mv;
	}
	/**
	 * 查询折扣分页
	 * @param discount
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/selectByPage", method = RequestMethod.POST)
	public @ResponseBody Pagination<Discount> selectByPage(@ModelAttribute("discount") Discount discount,HttpServletRequest request){
		discount.setPageParameter(getpagePageParameter());
		Pagination<Discount> pagination =this.discountService.selectByPage(discount);
		request.setAttribute("list",pagination);
		return pagination;
	}
	/**
	 * 添加折扣
	 * @return
	 */
	@RequestMapping(value = "/addDiscount")
	public ModelAndView addDiscount(){
		ModelAndView mv = new ModelAndView();
		//获取所有套餐列表
		List<Combo> comboList=this.comboService.selectComboList();
		mv.addObject("comboList", comboList);
		mv.setViewName("discount/add_discount");
		return mv;
	}
	/**
	 * 保存折扣
	 * @param discount
	 * @return
	 */
	@RequestMapping(value = "/saveDiscount")
	public@ResponseBody String saveDiscount(@ModelAttribute("discount") Discount discount){
		discount.setId(idService.NextKey("discount_id"));
		discount.setTime(new Date());
		discountService.insertSelective(discount);
		return "";
	}
	/**
	 * 删除折扣
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteDiscount", method = RequestMethod.POST)
	public @ResponseBody String deleteDiscount(@ModelAttribute("id") Integer id){
		 discountService.deleteByPrimaryKey(id);
		 return "";
	}
	/**
	 * 弹出修改折扣窗口
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/editDiscount/{id}", method = RequestMethod.GET)
	public ModelAndView editDiscount(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		Discount discount= discountService.selectByPrimaryKey(id);
		mv.addObject("discount", discount);
		mv.addObject("discountPrice", String.valueOf(discount.getDiscount()));
		//获取所有套餐列表
		List<Combo> comboList=this.comboService.selectComboList();
		mv.addObject("comboList", comboList);
		mv.setViewName("discount/edit_discount");
		return mv;
	}
	/**
	 * 保存修改折扣
	 * @param discount
	 * @return
	 */
	@RequestMapping(value = "/updateDiscount", method = RequestMethod.POST)
	public @ResponseBody String updateDiscount(@ModelAttribute("discount") Discount discount){
		discount.setTime(new Date());
		discountService.updateByPrimaryKeySelective(discount);
		return "";
	}
	
}
