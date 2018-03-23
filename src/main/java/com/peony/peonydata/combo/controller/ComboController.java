package com.peony.peonydata.combo.controller;



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
import com.peony.peonydata.key.service.IdService;
/**
 * E人E本套餐
 * @author zhyz
 *
 */
@Controller
@RequestMapping("/combo")
public class ComboController extends BaseController {
	@Autowired
	private ComboService comboService;
	@Autowired
	private IdService idService; // id服务接口
	/**
	 * 加载套餐列表
	 * @return
	 */
	@RequestMapping(value = "/comboList")
	public ModelAndView ComboList(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("combo/list_combo");
		return mv;
	}
	/**
	 * 查询套餐分页
	 * @param combo
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	public @ResponseBody Pagination<Combo> selectByPage(@ModelAttribute("combo") Combo combo,HttpServletRequest request){
		combo.setPageParameter(getpagePageParameter());
		Pagination<Combo> pagination =comboService.selectByPage(combo);
//		for(Combo c:pagination.getList()){
//			System.out.println(c.getPrice());
//		}
		request.setAttribute("list", pagination);
		return pagination;
	}
	/**
	 * 添加套餐
	 * @return
	 */
	@RequestMapping(value = "/addCombo")
	public ModelAndView addCombo(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("combo/add_combo");
		return mv;
	}
	/**
	 * 保存新建套餐
	 * @param combo
	 * @return
	 */
	@RequestMapping(value = "/saveCombo")
	public@ResponseBody String saveCombo(@ModelAttribute("Combo") Combo combo){
		combo.setId(idService.NextKey("combo_id"));
		combo.setStatus("0");
		comboService.insertSelective(combo);
		return "";
	}
	/**
	 * 删除套餐
	 * @param combo
	 * @return
	 */
	@RequestMapping(value = "/deleteCombo", method = RequestMethod.POST)
	public @ResponseBody String deleteCombo(@ModelAttribute("Combo") Combo combo){
		combo.setStatus("1");
		comboService.updateByPrimaryKeySelective(combo);
		return "";
	}
	/**
	 * 弹出修改窗口
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/editCombo/{id}", method = RequestMethod.GET)
	public ModelAndView editCombo(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response){
		Combo combo=comboService.selectByPrimaryKey(id);
		request.setAttribute("combo",combo);
		request.setAttribute("price",String.valueOf(combo.getPrice()));
		return new ModelAndView("combo/edit_combo");
	}
	/**
	 * 保存修改
	 * @param combo
	 * @return
	 */
	@RequestMapping(value = "/updateCombo", method = RequestMethod.POST)
	public @ResponseBody String updateCombo(@ModelAttribute("combo") Combo combo ){
		comboService.updateByPrimaryKeySelective(combo);
		return "";
	}
}
