package com.peony.peonydata.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.website.model.WebSite;
import com.peony.peonydata.website.service.WebSiteService;
@Controller
@RequestMapping("/website")
public class WebSiteController extends BaseController {
	@Autowired
	private WebSiteService webSiteService; 
	
	@Autowired
	private IdService idService;
	/**
	 * 跳转到列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/webSiteList")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("website/list_website");
		return mv;
		
	}
	/**
	 * website  帶分页
	 * @param request
	 * @param response
	 * @return
	 */
	 @RequestMapping(value = "/selectByPage", method = RequestMethod.POST)
	 @ResponseBody
	 public Pagination<WebSite> selectByPage(@ModelAttribute("webSite") WebSite webSite,
			HttpServletRequest request) {
		 webSite.setPageParameter(getpagePageParameter());
		Pagination<WebSite> pagination = this.webSiteService.selectByPage(webSite);
		request.setAttribute("list", pagination);
		return pagination;
	}

		/**
		 * 跳转到 --增加
		 * @param request
		 * @return
		 */
	@RequestMapping(value = "/addWebSite", method = RequestMethod.GET)
	public ModelAndView addWebSite(HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("website/add_website");
		return mv;
		
	}
	/**
	 * 保存增加
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/saveWebSite", method = { RequestMethod.POST })
	@ResponseBody
	public String saveWebSite(HttpServletRequest request, @ModelAttribute("webSite") WebSite webSite,HttpServletResponse response) {
		int id=this.idService.NextKey("web_site");
		webSite.setWebsiteId(id);
		this.webSiteService.insertSelective(webSite);
		return "";
	}
	/**
	 * 修改
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editWebSite/{id}")
	public ModelAndView editWebSite(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		WebSite ws=this.webSiteService.selectByPrimaryKey(id);
		mv.addObject("webSite", ws);
		mv.setViewName("website/edit_website");
		return mv;
	}
	/**
	 * 保存修改
	 * @param webSite
	 * @return
	 */
	@RequestMapping(value = "/updateWebSite")
	@ResponseBody
	public String updateWebSite(@ModelAttribute("webSite") WebSite webSite) {
		this.webSiteService.updateByPrimaryKeySelective(webSite);
		return "";
	}
	
	
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteWebSite")
    @ResponseBody
	public String deleteWebSite(@RequestParam(value = "id", required = true) int id) {
		this.webSiteService.deleteByPrimaryKey(id);
		return "";
	}
}
