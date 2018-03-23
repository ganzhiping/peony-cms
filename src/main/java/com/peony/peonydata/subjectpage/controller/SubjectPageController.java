package com.peony.peonydata.subjectpage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.peony.peonydata.subjectpage.model.SubjectPage;
import com.peony.peonydata.subjectpage.service.SubjectPageService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;
@Controller
@RequestMapping("/subjectpage")
public class SubjectPageController extends BaseController {
	@Autowired
	private SubjectPageService subjectPageService; 
	
	
	@Autowired
	private UserService userService; // 用户服务接口
	/**
	 * 查询全部
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/subjectPageList", method = RequestMethod.GET)
	public ModelAndView subjectPageList(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		User marketuser=(User)request.getSession().getAttribute("userModel");
		List<User> list=this.userService.selectByManagerId(marketuser.getUserId());
		User user=new User();
		List<User> userList=new ArrayList();
		if(list.size()>0){
			//根据市场用户 获取客户列表
			String userIds=listToString(list);
			user.setUserIds(userIds);
			userList=this.userService.selectUsers(user);
		}
		mv.addObject("userList",userList);
		mv.setViewName("subjectpage/list_subjectpage");
		return mv;
	}

	/**
	 * 查询全部
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectByPage", method = RequestMethod.POST)
	public @ResponseBody
	Pagination<SubjectPage> selectByPage(@ModelAttribute("subjectPage") SubjectPage subjectPage,
			HttpServletRequest request) {
		
		subjectPage.setPageParameter(getpagePageParameter());
	 	User marketuser=(User)request.getSession().getAttribute("userModel");
		 //获取当前市场用户下所管辖的市场用户
		List<User> list=this.userService.selectByManagerId(marketuser.getUserId());
		
		
	 	if(subjectPage.getUserIds()==null || "".equals(subjectPage.getUserIds())){
	 		//该市场人员下有被管理的市场人员
			if(list.size()>0){
				//根据市场用户 获取客户列表
				User user=new User();
				String userIds=listToString(list);
				user.setUserIds(userIds);
				List<User> userList=this.userService.selectUsers(user);
				if(userList.size()>0){
					subjectPage.setUserIds(String.valueOf(userList.get(0).getUserId()));
				}else{
					subjectPage.setUserIds("-1");
				}
			}else{
				subjectPage.setUserIds("-1");
			}
	 	}
		Pagination<SubjectPage> pagination = subjectPageService.selectByPage(subjectPage);
		request.setAttribute("list", pagination);
		return pagination;
	}
	/**
	 * 删除
	 */
	@RequestMapping(value = "/deleteSubjectPage")
	@ResponseBody
	public String deleteSubjectPage(
			@RequestParam(value = "ids", required = true) String ids,HttpServletRequest request) {
		String [] arry=ids.split(",");
		this.subjectPageService.deleteByPrimaryKey(arry);
		return "";
	}
	
	/**
	 * 设置正负面
	 */
	@RequestMapping(value = "/updateSubjectPageState")
	@ResponseBody
	public String updateSubjectPageState(
			@RequestParam(value = "ids", required = true) String ids,@RequestParam(value = "polarity", required = true) int polarity,HttpServletRequest request) {
		String [] arry=ids.split(",");
		this.subjectPageService.updateSubjectPageState(arry, polarity);
		return "";
	}
	
	/**
	 * 订制信息详细页
	 * @return
	 */
	@RequestMapping(value = "/loadSubjectPage")
	public ModelAndView loadSubjectPage(HttpServletRequest request,HttpServletResponse response) {
		SubjectPage subjectPage = new SubjectPage();
		String id=request.getParameter("id");
		
		if(null!=id && !"".equals(id)){
			subjectPage = this.subjectPageService.selectByPrimaryKey(id);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("subjectpage/show_page_info");
		mv.addObject("subjectPage", subjectPage);
		return mv;
	}
	
	
	  public static String listToString(List<User> list) {  
		    StringBuilder sb = new StringBuilder();  
		    if (list != null && list.size() > 0) {  
		        for (int i = 0; i < list.size(); i++) {  
		            if (i < list.size() - 1) {  
		                sb.append(list.get(i).getUserId() + ",");  
		            } else {  
		                sb.append(list.get(i).getUserId());  
		            }  
		        }  
		    }  
		    return sb.toString();  
		}  
}
