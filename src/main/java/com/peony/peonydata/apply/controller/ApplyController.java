package com.peony.peonydata.apply.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.apply.model.Apply;
import com.peony.peonydata.apply.service.ApplyService;

/**
 * 试用申请
 * @authorjhj
 *
 */
@Controller
@RequestMapping("/apply")
public class ApplyController extends BaseController{

	@Autowired
	private ApplyService applyService; 
	

	/**
	 * 跳转到申请列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/applyList")
	public ModelAndView list() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("apply/list_apply");
		return mv;
	}
	
	/**
	 * apply 分页  条件查询  status
	 * @param request
	 * @param response
	 * @return
	 */
	 @RequestMapping(value = "/selectByPage", method = RequestMethod.POST)
	 @ResponseBody
	 public Pagination<Apply> selectByPage(@ModelAttribute("apply") Apply apply,
			HttpServletRequest request) {
		apply.setPageParameter(getpagePageParameter());
		Pagination<Apply> pagination = this.applyService.selectByPage(apply);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
	
	/**
	 * ajax删除申请
	 * @param id
	 * @return map
	 */
	@RequestMapping(value = "/deleteApply")
	@ResponseBody
	public String deleteApply(@RequestParam(value = "id", required = true) String ids) {
		String [] array=ids.split(",");
		
		for(String id:array){
			this.applyService.deleteByPrimaryKey(Integer.valueOf(id));
			logger.info("delete apply success !");
		}
		return "";
	}
	
	/**
	 * ajax 更新状态 已阅
	 * @param id
	 * @return map
	 */
	@RequestMapping(value = "/updateApply")
	@ResponseBody
	public String updateApply(@RequestParam(value = "id", required = true) String ids) {
		String [] array=ids.split(",");
		for(String id:array){
			Apply apply=this.applyService.selectByPrimaryKey(Integer.valueOf(id));
			apply.setStatus("1");//已阅
			this.applyService.updateByPrimaryKeySelective(apply);
			logger.info("update apply status to 1");
		}
	return "";
	}
	
}
