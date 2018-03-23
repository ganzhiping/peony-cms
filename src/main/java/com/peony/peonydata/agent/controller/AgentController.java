package com.peony.peonydata.agent.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.agent.model.Agent;
import com.peony.peonydata.agent.service.AgentService;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.user.service.UserService;

/**
 * 代理商agent
 * @date 2014-5-26 下午03:08:49
 * @author zhaoyunzhao
 * @version 1
 */
@Controller
@RequestMapping("/agent")
public class AgentController extends BaseController {
	@Autowired
	private AgentService agentService;
	@Autowired
	private IdService idService; // id服务接口
	@Autowired
	private UserService userService;
	private static final String MarketPersonType="1";//市场人员标识
	
	/**
	 * 跳转到代理商列表页
	 * @return
	 */
	@RequestMapping(value = "/agentList", method = RequestMethod.GET)
	public ModelAndView userList() {
		 ModelAndView mv = new ModelAndView();
		 User user=new User();
		 user.setPersonType(MarketPersonType);
		 List<User> list=this.userService.selectUsers(user);
		 mv.addObject("list", list);
		 mv.setViewName("agent/list_agent");
		return mv;
	}

	/**
	 * 查询代理商列表
	 * @param agent
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/selectByPage", method = RequestMethod.GET)
	@ResponseBody
	public Pagination<Agent> selectByPage(@ModelAttribute("agent") Agent agent,
			HttpServletRequest request) {
		User operate=(User)request.getSession().getAttribute("userModel");
		agent.setCreateUserId(operate.getUserId());
		agent.setPageParameter(getpagePageParameter());
		Pagination<Agent> pagination = this.agentService.selectByPage(agent);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
	
	
	/**
	 * 跳转到代理商列表页all
	 * @return
	 */
	@RequestMapping(value = "/agentAllList", method = RequestMethod.GET)
	public ModelAndView agentAllList() {
		 ModelAndView mv = new ModelAndView();
		 User user=new User();
		 user.setPersonType(MarketPersonType);
		 List<User> list=this.userService.selectUsers(user);
		 mv.addObject("list", list);
		 mv.setViewName("agent/list_allAgent");
		return mv;
	}

	/**
	 * 查询代理商列表 leader
	 * @param agent
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/selectAllByPage", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Agent> selectAllByPage(@ModelAttribute("agent") Agent agent,
			HttpServletRequest request) {
		agent.setPageParameter(getpagePageParameter());
		Pagination<Agent> pagination = this.agentService.selectByPage(agent);
		request.setAttribute("list", pagination);
		return pagination;
	}

	/**
	 * 修改代理商跳转
	 */
	@RequestMapping(value = "/editAgent/{id}", method = RequestMethod.GET)
	public ModelAndView editAgent(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Agent agent = this.agentService.selectByAgentId(id);
		
		User user=new User();
		user.setPersonType(MarketPersonType);
		List<User> userList=this.userService.selectUsers(user);
		mv.addObject("userList", userList);
		mv.addObject("agent", agent);
		if(agent.getModel()==null){
			mv.setViewName("agent/edit_agent");
		}else{
			mv.setViewName("agent/edit_mobile_agent");
		}
		
		return mv;
	}

	/**
	 * 更新代理商信息
	 */
	@RequestMapping(value = "/updateAgent", method = RequestMethod.POST)
	@ResponseBody
	public String updateAgent(@ModelAttribute("agent") Agent agent,HttpServletRequest request, HttpServletResponse response) {
		String retString=savePicture(request,response);
		if(!"".equals(retString)){
			//删除原图片
			delPicture(agent.getLogo(),request);
			agent.setLogo(retString);
		}
		agentService.updateAgent(agent);
		return "";
	}

	/**
	 * 删除代理商
	 */
	@RequestMapping(value = "/deleteAgent")
	@ResponseBody
	public String deleteAgent(
			@RequestParam(value = "id", required = true) int id,HttpServletRequest request) {
		//删除原图片
		Agent agent = this.agentService.selectByAgentId(id);
		delPicture(agent.getLogo(), request);
		this.agentService.delAgent(id);
		return "";
	}

	/**
	 * 跳转到添加代理商页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toAddAgent", method = RequestMethod.GET)
	public ModelAndView toAddAgent() {
		ModelAndView mv = new ModelAndView();
		User user=new User();
		user.setPersonType(MarketPersonType);
		List<User> userList=this.userService.selectUsers(user);
		mv.addObject("userList", userList);
		mv.setViewName("agent/add_agent");
		return mv;
	}

	/**
	 * 更新代理商信息
	 */
	@RequestMapping(value = "/saveAgent", method = RequestMethod.POST)
	@ResponseBody
	public String saveAgent(@ModelAttribute("agent") Agent agent,HttpServletRequest request, HttpServletResponse response) {
		User operate=(User)request.getSession().getAttribute("userModel");
		agent.setCreateUserId(operate.getUserId());
		agent.setCreateUser(operate.getName());
		agent.setCreateTime(new Date());
		agent.setAgentId(idService.NextKey("agent_id"));
		String retString=savePicture(request,response);
		if("".equals(retString)){
			retString=null;
		}
		agent.setLogo(retString);
//		if("".equals(agent.getModel())){
//			agent.setModel(null);
//		}
		agentService.insertSelective(agent);
		return "";
	}
	
	//代理商查询页面
	@RequestMapping(value = "/selectAgents", method = RequestMethod.GET)
	public ModelAndView selectAgents(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		User marketuser=(User)request.getSession().getAttribute("userModel");
		List<User> list=this.userService.selectByManagerId(marketuser.getUserId());
		mv.addObject("list", list);
		mv.setViewName("agent/select_agent");
		return mv;
	}
	
	@RequestMapping(value = "/selectAgentByPage", method = RequestMethod.GET)
	@ResponseBody
	public Pagination<Agent> selectAgentByPage(@ModelAttribute("agent") Agent agent,
			HttpServletRequest request) {
		
	 	User marketuser=(User)request.getSession().getAttribute("userModel");
	 	
	 	if(agent.getUserIds()==null || "".equals(agent.getUserIds())){
	 		 //获取当前市场用户下所管辖的市场用户
			List<User> list=this.userService.selectByManagerId(marketuser.getUserId());
	 		String userIds=listToString(list);
	 		agent.setUserIds(userIds); //将所管辖的市场用户填入
		
	 	}
		Pagination<Agent> pagination = this.agentService.selectByPage(agent);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
	/**
	 * 保存图片
	 * @param agent
	 * @param request
	 * @param response
	 * @return
	 */
	private String savePicture(HttpServletRequest request, HttpServletResponse response){
		String retString = "";
		// 图片文件夹,/uploads/agent/...
		String userDir ="/upload/agent/";
		// 头像上传文件夹,绝对路径,d:/...
		String pictureDir = request.getSession().getServletContext()
						.getRealPath("/")
						+ userDir;
		
		 File file = new File(pictureDir);
		// 如果没有文件夹,创建
		 if (!file.exists()) {
			   file.mkdir();
			  }
		MultipartHttpServletRequest multipartRequest = null;
		try {
			multipartRequest = (MultipartHttpServletRequest) request;
		} catch (Exception e1) {
			logger.error(e1.toString());
		}
		Iterator<String> iter = multipartRequest.getFileNames();
		while (iter.hasNext()) {
			MultipartFile uploadFile = multipartRequest
					.getFile((String) iter.next());
			if (uploadFile != null) {
				// 上传后图片名称
				StringBuilder pictureFileName = new StringBuilder();

				// 图片上传的全路径,包括绝对路径和图片文件名称
				StringBuilder pictureFullPath = new StringBuilder();

				// 图片url地址,用于页面上展示图片,/uploads/agent/...
				StringBuilder pictureUrl = new StringBuilder();
					
				// 上传后头像文件名称，为原文件名称
				DateFormat format = new SimpleDateFormat("yyyyMMddhhmmss"); 
				pictureFileName.append(format.format(new Date())+"_"+uploadFile.getOriginalFilename());
				// 图片url地址,用于页面上展示头像
				pictureUrl.append(userDir).append(pictureFileName);
				// 图片上传的全路径,包括绝对路径和图片文件名称
				pictureFullPath.append(pictureDir).append(pictureFileName);
//				System.out.println(pictureFileName);
				try {
					// 上传文件,重点就是这两句
					File localFile = new File(pictureFullPath.toString());
					uploadFile.transferTo(localFile);
					retString = pictureUrl.toString();
					response.flushBuffer();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return retString;
	}
	/**
	 * 删除原有图片
	 * @param id
	 */
	private void delPicture(String url,HttpServletRequest request){
		if(url!=null){
			String pictureDir = request.getSession().getServletContext()
					.getRealPath("/")
					+ url.replaceAll("\\\\","/");
			 File file = new File(pictureDir);
			 if(file.isFile() && file.exists()){
				 file.delete();
			 }
		} 
		}
	/**
	 * 将用户列表中用户id 转化为‘，’号分隔字符串
	 * @param list
	 * @return
	 */
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
	/**
	 * 跳转到代理商列表页all(免费移动版)
	 * @return
	 */
	@RequestMapping(value = "/agentMobileAllList", method = RequestMethod.GET)
	public ModelAndView agentMobileAllList() {
		 ModelAndView mv = new ModelAndView();
		 User user=new User();
		 user.setPersonType(MarketPersonType);
		 List<User> list=this.userService.selectUsers(user);
		 mv.addObject("list", list);
		 mv.setViewName("agent/list_mobile_allAgent");
		return mv;
	}
	/**
	 * 查询代理商列表 leader
	 * @param agent
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/selectAllMobileByPage", method = RequestMethod.POST)
	@ResponseBody
	public Pagination<Agent> selectAllMobileByPage(@ModelAttribute("agent") Agent agent,
			HttpServletRequest request) {
		agent.setPageParameter(getpagePageParameter());
		Pagination<Agent> pagination = this.agentService.selectMobileByPage(agent);
		request.setAttribute("list", pagination);
		return pagination;
	}
	/**
	 * 跳转到添加代理商页面(移动免费版)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toAddMobileAgent", method = RequestMethod.GET)
	public ModelAndView toAddMobileAgent() {
		ModelAndView mv = new ModelAndView();
		User user=new User();
		user.setPersonType(MarketPersonType);
		List<User> userList=this.userService.selectUsers(user);
		mv.addObject("userList", userList);
		mv.setViewName("agent/add_mobile_agent");
		return mv;
	}
}
