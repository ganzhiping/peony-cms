package com.peony.peonydata.region.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.peonydata.baseclass.model.BaseClass;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.region.model.Region;
import com.peony.peonydata.region.model.RegionKeywords;
import com.peony.peonydata.region.service.RegionKeywordsService;
import com.peony.peonydata.region.service.RegionService;
import com.peony.peonydata.subject.model.Subject;
import com.peony.peonydata.subject.service.SubjectService;
import com.peony.peonydata.subjectkeywords.model.SubjectKeywords;
import com.peony.peonydata.subjectkeywords.service.SubjectKeywordsService;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.userRegion.model.UserRegion;
import com.peony.peonydata.userRegion.service.UserRegionService;
import com.peony.peonydata.util.JSONUtil;

/**
 * 地域管理
 * @author jhj
 */
@Controller
@RequestMapping("/region")
public class RegionController extends BaseController {


	@Autowired
	private RegionService regionService; // 地域服务接口
	
	@Autowired
	private IdService idService; // 菜单服务接口
	
	@Autowired
	private RegionKeywordsService regionKeywordsService;
	
	@Autowired
	private UserRegionService userRegionService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private SubjectKeywordsService subjectKeywordsService;

	private List<Region> regionTreeList=new ArrayList<Region>();
	
	@RequestMapping(value = "/regionList", method = RequestMethod.GET)
	public ModelAndView regionList(@ModelAttribute("region") Region region) {
		ModelAndView mv = new ModelAndView();
		region.setParentid(-1);
		List<Region> regionList=this.regionService.selectRegions(region);
		
		List<ZTreeNode> nodes = nodeList(regionList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("region/list_region");
		return mv;
	}
	/**
	 * 根据id加载地域
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loadRegion/{id}", method = RequestMethod.GET)
	public ModelAndView loadRegion(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		Region region =regionService.selectByPrimaryKey(id);
		request.setAttribute("region", region);

		return new ModelAndView("region/region_info");
	}


	@RequestMapping(value = "/findChildren")
	@ResponseBody
	public List<ZTreeNode> findChildren(Model model, HttpServletRequest request) {
		// id = null 查父子节点
		String parentCode = request.getParameter("id");
		if (null == parentCode || "".equals(parentCode)) {
			parentCode = "0";
		}
		List<Region> list =regionService.findChildren(parentCode);
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());

		for (Region region : list) {
			ZTreeNode node = new ZTreeNode();
			node.setId(String.valueOf(region.getRegionid()));
			node.setName(region.getRegionname());
			node.setOpen(false);
			node.setIsParent(regionService.loadHasChildren(String.valueOf(region.getRegionid())) ? "true" : "false");
			nodeList.add(node);
		}
		return nodeList;
	}
	/**
	 * 查询全部地域
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/selectRegions")
	public @ResponseBody
	List<ZTreeNode> selectRegions(@ModelAttribute("region") Region region, String id) {
		region.setParentid(-1);
		List<Region> regionList = regionService.selectRegions(region);
		List nodeList = nodeList(regionList, id);
		return nodeList;
	}

	/**
	 * 修改地域
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editRegion/{id}")
	public ModelAndView editRegion(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		Region region=new Region();
		region.setParentid(-1);
		List<Region> regionList = regionService.selectRegions(region);
		List<ZTreeNode> nodes = nodeList(regionList, String.valueOf(id));
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		region = regionService.selectByPrimaryKey(id);
		
		Region father=this.regionService.selectByPrimaryKey(region.getParentid());
		String fatherName="";
		if(father!=null){
			fatherName=father.getRegionname();
		}
		
		mv.addObject("fatherName",fatherName);
		mv.addObject("region", region);
		mv.setViewName("region/edit_region");
		return mv;
	}
	/**
	 * 修改地域关键词
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/editRegionKeywords/{id}")
	public ModelAndView editRegionKeywords(@PathVariable("id") String id){
		ModelAndView mv = new ModelAndView();
		RegionKeywords regionKeywords=new RegionKeywords();
		regionKeywords=regionKeywordsService.selectByPrimaryKey(id);
		mv.addObject("regionKeywords",regionKeywords);
		mv.setViewName("region/edit_region_keywords");
		return mv;
	}
	/**
	 * 保存修改
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/updateRegion")
	@ResponseBody
	public String updateRegion(@ModelAttribute("region") Region region) {
		regionService.updateByPrimaryKeySelective(region);
		return "";
	}
	/**
	 * 保存地域关键词修改
	 * @param regionKeywords
	 * @return
	 */
	@RequestMapping(value="/updateRegionKeywords")
	@ResponseBody
	public String updateRegionKeywords(@ModelAttribute("regionKeywords") RegionKeywords regionKeywords , HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("userModel");
		regionKeywords.setUserName(user.getLoginName());
		regionKeywords.setModifyTime(new Date());
		int i=regionKeywordsService.updateByPrimaryKeySelective(regionKeywords);
//		if(i==1){
//			String regionId=regionKeywords.getRegionid();
//			if(regionId.length()==6){
//				updateSubjectKeywords(regionId);
//				regionId=regionId.substring(0, 4);
//			}
//			if(regionId.length()==4){
//				updateSubjectKeywords(regionId);
//				regionId=regionId.substring(0, 4);
//			}
//			if(regionId.length()==2){
//				updateSubjectKeywords(regionId);
//			}
//		} 
		return "";
	}
	
	/**
	 * 增加地域
	 * @return
	 */
	@RequestMapping(value = "/addRegion", method = RequestMethod.GET)
	public ModelAndView addRegion() {
		ModelAndView mv = new ModelAndView();
		Region region=new Region();
		region.setParentid(-1);
		List<Region> regionList = regionService.selectRegions(region);
		List<ZTreeNode> nodes = nodeList(regionList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("region/add_region");
		return mv;
	}

	
	/**
	 * 选择地域
	 * @return
	 */
	@RequestMapping(value = "/selectRegion", method = RequestMethod.GET)
	public ModelAndView selectRegion() {
		ModelAndView mv = new ModelAndView();
		Region region=new Region();
		region.setParentid(-1);
		List<Region> regionList = regionService.selectRegions(region);
		List<ZTreeNode> nodes = nodeList(regionList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("region/selectRegion");
		return mv;
	}
	/**
	 * 保存增加
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/saveRegion")
	@ResponseBody
	public String saveRegion(@ModelAttribute("region") Region region) {
		region.setRegionid(idService.NextKey("region_id"));
		regionService.insertSelective(region);
		return "";
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteRegion")
	@ResponseBody
	public String deleteRegion(
			@RequestParam(value = "id", required = true) int id) {
		regionService.deleteByPrimaryKey(id);
		return "";
	}

	
	/**
	 * 添加用户时 跳转到选择地域界面
	 * @return
	 */
	@RequestMapping(value = "/userSelectRegion", method = RequestMethod.GET)
	public ModelAndView userSelectRegion(@ModelAttribute("region") Region region) {
		ModelAndView mv = new ModelAndView();
		region.setParentid(-1);
		List<Region> regionList=this.regionService.selectRegions(region);
		
		List<ZTreeNode> nodes = nodeList(regionList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("customer/region_tree");
		return mv;
	}
	
	/**
	 * 返回ztree列表
	 * @param list
	 * @return
	 */
	public List<ZTreeNode> nodeList(List<Region> list, String checkid) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());
	
		for (Region region : list) {
			ZTreeNode node = new ZTreeNode();
			node.setId(String.valueOf(region.getRegionid()));
			node.setPId(String.valueOf(region.getParentid()));
			node.setIsParent(regionService.loadHasChildren(String.valueOf(region.getRegionid())) ? "true" : "false");
			node.setName(region.getRegionname());
			nodeList.add(node);
		}
		return nodeList;

	}
	
	
	@RequestMapping(value = "/selectAllChildNodes/{pid}", method = RequestMethod.GET)
	public ModelAndView selectAllChildNodes(@PathVariable("pid") Integer pid) {
		ModelAndView mv = new ModelAndView();
		Region region=this.regionService.selectByPrimaryKey(pid);
		regionTreeList.add(region);
		List<Region> list=getChildNodeList("11",true);
		List<ZTreeNode> nodes = nodeList(regionTreeList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		regionTreeList.clear();
		
		return mv;
	}
	
	/**
	 * 根据父节点查询子节点  onlyFirstfloor为true 只查一级节点  ，false 查询全部节点
	 * @param id
	 * @param onlyFirstfloor
	 * @return
	 */
	public List<Region> getChildNodeList(String pid,boolean onlyFirstfloor){
		boolean isHasChild=this.regionService.loadHasChildren(pid);
		if(isHasChild){
	    	  List<Region> list=this.regionService.findChildren(pid);
	    	  for(Region region :list){
	    		  regionTreeList.add(region);
	    		  if(!onlyFirstfloor){
	    			  getChildNodeList(String.valueOf(region.getRegionid()),false);
	    		  }
	    	  }
	    	  
	      }
		return regionTreeList;
		
	}
	
	
}
