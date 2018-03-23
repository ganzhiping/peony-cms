package com.peony.peonydata.channel.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.channel.model.Channel;
import com.peony.peonydata.channel.model.PubInfo;
import com.peony.peonydata.channel.model.PubInfoCnt;
import com.peony.peonydata.channel.service.ChannelService;
import com.peony.peonydata.channel.service.PubInfoCntService;
import com.peony.peonydata.channel.service.PubInfoService;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.util.JSONUtil;
@Controller
@RequestMapping("/pubInfo")
public class PubInfoController extends BaseController {

	@Autowired
	private PubInfoService pubInfoService;
	@Autowired
	private IdService idService; 
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private PubInfoCntService pubInfoCntService;
	
	
	
	/**
	 * 跳转到基础类型树
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/channelList")
	public ModelAndView channelList() {
		ModelAndView mv=new ModelAndView();
		List<Channel> list = this.channelService.selectChannels();
		List<ZTreeNode> nodes = nodeList(list, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("pubinfo/channel_tree");
		return mv;
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
			node.setIsParent(channelService.loadHasChildren(String.valueOf(channel.getChannelId())) ? "true" : "false");
			nodeList.add(node);
		}
		return nodeList;

	}
	/**
	 * 跳转到案例列表页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/infoList")
	public ModelAndView list(@RequestParam(value = "channelId", required = true) int channelId) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("channelId",channelId);
		mv.setViewName("pubinfo/list_pubinfo");
		return mv;
	}

	/**
	 *  帶分页  根据channelId 获取案例列表
	 * @param request channelId
	 * @param response
	 * @return
	 */
	 @RequestMapping(value = "/selectByPage", method = RequestMethod.POST)
	 @ResponseBody
	 public Pagination<PubInfo> selectByPage(@ModelAttribute("pubInfo") PubInfo pubInfo,
			HttpServletRequest request) {
		 pubInfo.setPageParameter(getpagePageParameter());
		Pagination<PubInfo> pagination = this.pubInfoService.selectByPage(pubInfo);
		request.setAttribute("list", pagination);
		return pagination;
	}
	
	
	

	/**
	 * 跳转到案例添加
	 * @param channelId
	 * @return mv
	 */
	@RequestMapping(value = "/addPubInfo", method = RequestMethod.GET)
	public ModelAndView addPubInfo(@RequestParam(value = "channelId", required = true) int channelId) {
		ModelAndView mv=new ModelAndView();
		int id=this.idService.NextKey("pub_info");
		mv.addObject("pubinfoId", id);
		mv.addObject("channelId", channelId);
		mv.setViewName("pubinfo/add_pubinfo");
		return mv;
	}

	/**
	 * 保存增加
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/savePubInfo", method = { RequestMethod.POST })
	@ResponseBody
	public String savePubInfo(HttpServletRequest request, PubInfo pubInfo,HttpServletResponse response) {
		
//		String retString=savePicture(request,response);
//		if("".equals(retString)){
//			retString=null;
//		}
//		pubInfo.setImage(retString);
		pubInfo.setTime(new Date());
		 this.pubInfoService.insertSelective(getPubInfo(pubInfo,savePicture(request,response)));
		return "";
	}

	
	/**
	 * 跳转到 --跳转到修改案例
	 * @param pubinfoId
	 * @return mv
	 */
	@RequestMapping(value = "/editPubInfo")
	public ModelAndView editPubInfo(@RequestParam(value = "pubinfoId", required = true) int pubinfoId) {
		ModelAndView mv=new ModelAndView();
	    PubInfo pubInfo=this.pubInfoService.selectByPrimaryKey(pubinfoId);
	    PubInfoCnt cnt=this.pubInfoCntService.selectByPrimaryKey(pubinfoId);
	 
		mv.addObject("pubInfo", pubInfo);
		mv.addObject("content", cnt.getContent());
		mv.setViewName("pubinfo/edit_pubinfo");
		return mv;
	}

	
	/**
	 * 修改保存
	 * @param 
	 * @return mv
	 */
	@RequestMapping(value = "/updatePubInfo", method = RequestMethod.POST)
	@ResponseBody
	public String updatePubInfo(HttpServletRequest request, PubInfo pubInfo,HttpServletResponse response) {
//		String retString=savePicture(request,response);
//		if("".equals(retString)){
//			retString=null;
//		}
		
//		pubInfo.setImage(retString);
	    this.pubInfoService.updateByPrimaryKeySelective(getPubInfo(pubInfo,savePicture(request,response)));
		return "";
		}
	
	@RequestMapping(value = "/recommend", method = RequestMethod.POST)
	@ResponseBody
	public String recommend(HttpServletRequest request, PubInfo pubInfo,HttpServletResponse response) {
	    this.pubInfoService.updateBySelective(pubInfo);
		return "";
		}
	/**
	 * 删除案例
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletePubInfo")
	@ResponseBody
	public String deletePubInfo(@RequestParam(value = "pubinfoId", required = true) int id) {
		this.pubInfoService.deleteByPrimaryKey(id);
		return "";
	}
	/**
	 * 获得存储图片路径的pubInfo
	 * @param pubInfo
	 * @param map
	 * @return
	 */
	private PubInfo getPubInfo(PubInfo pubInfo,Map<String ,String> map){
		//保存pc图片
		if("".equals(map.get("bannerFile"))){
			pubInfo.setImage(null);
		}else{
			pubInfo.setImage(map.get("bannerFile"));
		}
		//保存pad大图
		if("".equals(map.get("bigFile"))){
			pubInfo.setBigImage(null);
		}else{
			pubInfo.setBigImage(map.get("bigFile"));
		}
		//保存pad长图
		if("".equals(map.get("longFile"))){
			pubInfo.setLongImage(null);
		}else{
			pubInfo.setLongImage(map.get("longFile"));
		}
		//保存pad小图
		if("".equals(map.get("smallFile"))){
			pubInfo.setSmallImage(null);
		}else{
			pubInfo.setSmallImage(map.get("smallFile"));
		}
		return pubInfo;
	}
	
	/**
	 * 保存图片
	 * @param agent
	 * @param request
	 * @param response
	 * @return
	 */
	private Map savePicture(HttpServletRequest request, HttpServletResponse response){
		
		String userDir ="upload/info/";
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
		Map<String,String> map=new HashMap<String, String>();
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
					String retString = pictureUrl.toString();
					map.put(uploadFile.getName(), retString);
					response.flushBuffer();
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return map;
	}
	
	
    
    @RequestMapping(value = "/convert", method = RequestMethod.GET)
    public void convert() {
    	
    	/*List<PubInfoCnt> list=this.pubInfoCntService.selectPubinfoCnts();
    	for(PubInfoCnt pubinfocnt:list){
    		
        	String text=pubinfocnt.getContent().replaceAll("http://mdyq.peonydata.com", "http://user.peonydata.com");

        	System.out.println(text);
        	pubinfocnt.setContent(text);
        	this.pubInfoCntService.updateByPrimaryKeySelective(pubinfocnt);
    	}*/
    
    	
    	
    }
}
