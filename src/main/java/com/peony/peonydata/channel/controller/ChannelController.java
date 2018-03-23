package com.peony.peonydata.channel.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.peony.core.base.controller.BaseController;
import com.peony.peonydata.channel.model.Channel;
import com.peony.peonydata.channel.service.ChannelService;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.util.JSONUtil;

/**
 * @author 案例分类
 *
 */
@Controller
@RequestMapping("/channel")
public class ChannelController extends BaseController {

	@Autowired
	private ChannelService channelService; 
	@Autowired
	private IdService idService; // 部门服务接口
	
	@RequestMapping(value = "/channelList", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<Channel> channelList = this.channelService.selectChannels();
		List<ZTreeNode> nodes = nodeList(channelList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("channel/list_channel");
		return mv;
	}
	
	
	/**
	 * 根据id加载地域
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loadChannel/{id}", method = RequestMethod.GET)
	public ModelAndView loadChannel(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		Channel channel = this.channelService.selectByPrimaryKey(id);
		request.setAttribute("channel", channel);

		return new ModelAndView("channel/channel_info");
	}

	/**
	 * 修改区域
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editChannel/{id}")
	public ModelAndView editChannel(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		List<Channel> channelList = channelService.selectChannels();
		List<ZTreeNode> nodes = nodeList(channelList, String.valueOf(id));
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		Channel channel = channelService.selectByPrimaryKey(id);
		Channel father=this.channelService.selectByPrimaryKey(channel.getChannelPid());
		String fatherName="";
		if(father!=null){
			fatherName=father.getName();
		}
		
		mv.addObject("fatherName",fatherName);
		mv.addObject("channel", channel);
		mv.setViewName("channel/edit_channel");
		return mv;
	}

	/**
	 * 保存修改
	 * @param Channel
	 * @return
	 */
	@RequestMapping(value = "/updateChannel")
	@ResponseBody
	public String updateChannel(@ModelAttribute("channel") Channel channel) {
		this.channelService.updateByPrimaryKeySelective(channel);
		return "";
	}

	/**
	 * 增加Channel  
	 * @return
	 */
	@RequestMapping(value = "/addChannel")
	public ModelAndView addChannel() {
		ModelAndView mv = new ModelAndView();
		List<Channel> channelList = channelService.selectChannels();
		List<ZTreeNode> nodes = nodeList(channelList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("channel/add_channel");
		return mv;
	}

	/**
	 * 保存增加
	 * 
	 * @param Channel
	 * @return
	 */
	@RequestMapping(value = "/saveChannel")
	@ResponseBody
	public String saveChannel(@ModelAttribute("channel") Channel channel) {
		channel.setChannelId(idService.NextKey("channel_id"));
		channelService.insertSelective(channel);
		return "";
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteChannel")
	@ResponseBody
	public String deleteChannel(
			@RequestParam(value = "id", required = true) int id) {
		channelService.deleteByPrimaryKey(id);
		return "";
	}

	
	
	@RequestMapping(value = "/findChildren")
	@ResponseBody
	public List<ZTreeNode> findChildren(Model model, HttpServletRequest request) {
		// id = null 查父子节点
		String parentCode = request.getParameter("id");
		if (null == parentCode || "".equals(parentCode)) {
			parentCode = "0";
		}
		List<Channel> list = channelService.findChildren(parentCode);
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());

		for (Channel channel : list) {
			ZTreeNode node = new ZTreeNode();
			node.setId(String.valueOf(channel.getChannelId()));
			node.setName(channel.getName());
			node.setOpen(true);
			node.setIsParent(channelService.loadHasChildren(String.valueOf(channel
					.getChannelId())) ? "true" : "false");
			nodeList.add(node);
		}
		return nodeList;
	}
	
	/**
	 * 返回ztree列表
	 * 
	 * @param list
	 * @return
	 */
	public List<ZTreeNode> nodeList(List<Channel> list, String checkid) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());
		String pid = "";
		for (Channel channel : list) {
			if (checkid.equals(String.valueOf(channel.getChannelId()))) {
				pid = String.valueOf(channel.getChannelPid());
				break;
			}
		}
		for (Channel channel : list) {
			ZTreeNode node = new ZTreeNode();
			if (pid.equals(String.valueOf(channel.getChannelId()))) {
				node.setChecked(true);
			}
			node.setId(String.valueOf(channel.getChannelId()));
			node.setPId(String.valueOf(channel.getChannelPid()));
			node.setName(channel.getName());
			node.setOpen(true);
			node.setIsParent(channelService.loadHasChildren(String.valueOf(channel
					.getChannelId())) ? "true" : "false");
			nodeList.add(node);
		}
		return nodeList;

	}
	
	 /**
	  * 添加案例
	  * @return
	 */
	@RequestMapping(value = "/addContent", method = RequestMethod.GET)
	  public ModelAndView addContent() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("publicinfo/info_add");
		return mv;
	}
	
	 
	 
	 /**
	 * 富文本编辑器上传图片
	 * @param request
	 * @param response
	 * @return
	 */

	 @RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
	 @ResponseBody
	 public String uploadImg(HttpServletRequest request,HttpServletResponse response) {
		 response.setContentType("text/html; charset=UTF-8");
		 // 文件保存目录路径
		 String savePath = request.getSession().getServletContext().getRealPath("/")+ "attached/";

		 // 文件保存目录URL
		 String saveUrl = request.getContextPath() + "/attached/";
		 // 定义允许上传的文件扩展名
		 String[] fileTypes = new String[] { "gif", "jpg", "jpeg", "png", "bmp" };
		 // 最大文件大小
		 long maxSize = 2*1024*1024;//2M
		 PrintWriter out = null;
		 try {
			 out = response.getWriter();
		 } catch (IOException e1) {}

		 // 检查目录
		 File uploadDir = new File(savePath);
		 if (!uploadDir.isDirectory()) {
			 out.println(getError("上传目录不存在。"));
			 return null;
		 }
		 // 检查目录写权限
		 if (!uploadDir.canWrite()) {
			 out.println(getError("上传目录没有写权限。"));
			 return null;
		 }
		 // 创建文件夹
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		 String ymd = sdf.format(new Date());
		 savePath += ymd + "/";
		 saveUrl += ymd + "/";
		 File dirFile = new File(savePath);
		 if (!dirFile.exists()) {
			 dirFile.mkdirs();
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

				 String fileExt = uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
				 if (!Arrays.<String> asList(fileTypes).contains(fileExt)) {
					 out.println(getError("上传文件扩展名[" + fileExt + "]是不允许的扩展名。"));
					 return null;
				 }
				 if (uploadFile.getSize() > maxSize) {
					 out.println(getError("[ " + uploadFile.getOriginalFilename() + " ]超过单个文件大小限制，文件大小[ " + uploadFile.getSize()+ " ]，限制为[ " + maxSize + " ] "));
					 return null;
				 }
				 SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				 String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
				 File uploadedFile = new File(savePath, newFileName);
				 try {
					 uploadFile.transferTo(uploadedFile);
					 JSONObject obj = new JSONObject();
					 obj.put("error", 0);
					 obj.put("url", "http://user.peonydata.com"+saveUrl + newFileName);
					 out.println(obj.toString());
					 // out.write(obj.toString());
					 out.close();
					 // log.debug("上传图片:[" + uploadedFile.getName() + "]" + ">>>[" + newFileName + "]成功");
				 } catch (IOException e) {
					 // log.error("图片上传失败:" + e);
				 }



			 }
		 }

		 return null;
	 }

	/*@RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
	 @ResponseBody
	 public String uploadImg(HttpServletRequest request,HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
         // 文件保存目录路径
        String savePath =  "/var/apache-tomcat-7.0.81/peony-tancms/attached/";
        
        // 文件保存目录URL
        String saveUrl = "/attached/";
         // 定义允许上传的文件扩展名
        String[] fileTypes = new String[] { "gif", "jpg", "jpeg", "png", "bmp" };
        // 最大文件大小
        long maxSize = 2*1024*1024;//2M
        PrintWriter out = null;
        try {
            	out = response.getWriter();
        } catch (IOException e1) {}

        // 检查目录
        File uploadDir = new File(savePath);
        if (!uploadDir.isDirectory()) {
			uploadDir.mkdirs();
            //out.println(getError("上传目录不存在。"));
           // return null;
        }
        // 检查目录写权限
       if (!uploadDir.canWrite()) {
            out.println(getError("上传目录没有写权限。"));
            return null;
        }
	     // 创建文件夹
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	     String ymd = sdf.format(new Date());
	     savePath += ymd + "/";
	     saveUrl += ymd + "/";
	     File dirFile = new File(savePath);
	     if (!dirFile.exists()) {
	         dirFile.mkdirs();
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
	     
				  String fileExt = uploadFile.getOriginalFilename().substring(uploadFile.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
			         if (!Arrays.<String> asList(fileTypes).contains(fileExt)) {
			             out.println(getError("上传文件扩展名[" + fileExt + "]是不允许的扩展名。"));
			             return null;
			         }
			        if (uploadFile.getSize() > maxSize) {
			            out.println(getError("[ " + uploadFile.getOriginalFilename() + " ]超过单个文件大小限制，文件大小[ " + uploadFile.getSize()+ " ]，限制为[ " + maxSize + " ] "));
			             return null;
			         }
			         SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			         String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
			         File uploadedFile = new File(savePath, newFileName);
			         System.out.println("savePath============="+savePath);
			         try {
			        	 uploadFile.transferTo(uploadedFile);

			             JSONObject obj = new JSONObject();
			             obj.put("error", 0);
			             obj.put("url", "http://mdyq.peonydata.com"+saveUrl+ newFileName);
			             out.println(obj.toString());
			            // out.write(obj.toString()); 
			             out.close(); 
			            // log.debug("上传图片:[" + uploadedFile.getName() + "]" + ">>>[" + newFileName + "]成功");
			         } catch (IOException e) {
			            // log.error("图片上传失败:" + e);
			         }
			      
				
	     
			}
			}
		
		 return null;
	 }*/
    private String getError(String message) {
        JSONObject obj = new JSONObject();
        obj.put("error", 1);
        obj.put("message", message);
        return obj.toString();
    }
	

}
