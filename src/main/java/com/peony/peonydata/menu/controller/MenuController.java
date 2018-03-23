package com.peony.peonydata.menu.controller;

import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import com.peony.core.base.controller.BaseController;
import com.peony.peonydata.dept.model.ZTreeNode;
import com.peony.peonydata.key.service.IdService;
import com.peony.peonydata.menu.model.Menu;
import com.peony.peonydata.menu.service.MenuService;
import com.peony.peonydata.rolemenu.model.RoleMenu;
import com.peony.peonydata.rolemenu.service.RoleMenuService;
import com.peony.peonydata.userRole.model.UserRole;
import com.peony.peonydata.util.JSONUtil;

/**
 * 菜单 controller
 * 
 * @date 2013-10-24 下午05:38:49
 * @author zhaoshutao
 * @version 1
 */

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

	@Autowired
	private MenuService menuService; // 菜单服务接口
	
	@Autowired
	private RoleMenuService roleMenuService; // 角色菜单服务接口
	@Autowired
	private IdService idService; // 菜单服务接口

	/**
	 * 根据id加载菜单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/menuList", method = RequestMethod.GET)
	public ModelAndView menuList() {
		ModelAndView mv = new ModelAndView();
		List<Menu> menuList = menuService.selectAllMenus();
		List<ZTreeNode> nodes = nodeList(menuList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("menu/list_menu");
		return mv;
	}

	/**
	 * 根据id加载菜单
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loadMenu/{id}", method = RequestMethod.GET)
	public ModelAndView loadMenu(@PathVariable int id,
			HttpServletRequest request, HttpServletResponse response) {
		Menu menu = menuService.selectByPrimaryKey(id);
		request.setAttribute("menu", menu);

		return new ModelAndView("menu/menu_info");
	}

	
	/**
	 * 修改菜单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editMenu/{id}")
	public ModelAndView editMenu(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		List<Menu> menuList = menuService.selectAllMenus();
		List<ZTreeNode> nodes = nodeList(menuList, String.valueOf(id));
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		Menu menu = menuService.selectByPrimaryKey(id);
		mv.addObject("menu", menu);
		mv.setViewName("menu/edit_menu");
		return mv;
	}

	/**
	 * 保存修改
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/updateMenu")
	@ResponseBody
	public String updateMenu(@ModelAttribute("menu") Menu menu) {
		menuService.updateByPrimaryKeySelective(menu);
		return "";
	}

	/**
	 * 增加菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addMenu", method = RequestMethod.GET)
	public ModelAndView addMenu() {
		ModelAndView mv = new ModelAndView();
		List<Menu> menuList = menuService.selectAllMenus();
		List<ZTreeNode> nodes = nodeList(menuList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		mv.setViewName("menu/add_menu");
		return mv;
	}

	/**
	 * 保存增加
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping(value = "/saveMenu")
	@ResponseBody
	public String saveMenu(@ModelAttribute("menu") Menu menu) {
		menu.setMenuId(idService.NextKey("menu_id"));
		menuService.insertSelective(menu);
		return "";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteMenu")
	@ResponseBody
	public String deleteMenu(
			@RequestParam(value = "id", required = true) int id) {
		menuService.deleteByPrimaryKey(id);
		return "";
	}

	/**
	 * 返回ztree列表
	 * 
	 * @param list
	 * @return
	 */
	public List<ZTreeNode> nodeList(List<Menu> list, String checkid) {
		List<ZTreeNode> nodeList = new ArrayList<ZTreeNode>(list.size());
		Integer pid = 0;
		for (Menu dpt1 : list) {
			if (checkid.equals(String.valueOf(dpt1.getMenuId()))) {
				pid = dpt1.getMenuPid();
				break;
			}
		}
		for (Menu dpt : list) {
			ZTreeNode node = new ZTreeNode();
			if (pid.equals(dpt.getMenuId())) {
				node.setChecked(true);
			}
			node.setId(String.valueOf(dpt.getMenuId()));
			node.setPId(String.valueOf(dpt.getMenuPid()));
			node.setName(dpt.getName());
			node.setOpen(false);

			nodeList.add(node);
		}
		return nodeList;

	}
	
	
	/**
	 * 修改角色-菜单 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/editRoleMenu/{id}")
	public ModelAndView editRoleMenu(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		List<Menu> menuList = menuService.selectMenus();
		List<ZTreeNode> nodes = nodeList(menuList, "");
		mv.addObject("nodeList", JSONUtil.array2JSON2(nodes.toArray()));
		
		List<Menu> selectMenuList=this.menuService.selectByRoleId(id);
		String idslist="";
		if(selectMenuList.size()>0){
		
		for(Menu menu:selectMenuList){
			idslist+=menu.getMenuId()+",";
		}
		//select menus 根据roleId  return ids
		idslist=idslist.substring(0,idslist.length()-1);//去掉最后多出来的逗号
		}
		mv.addObject("idslist", idslist);
		mv.addObject("roleId", id);
		mv.setViewName("menu/role_menu");
		return mv;
	}

	
	/**
	 * 保存修改
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/saveRoleMenu")
	@ResponseBody
	public String saveRoleMenu(@ModelAttribute("roleMenu") RoleMenu roleMenu) {
       this.roleMenuService.updateRoleMenu(roleMenu);
	   return "";
	
	}
	
	
	
}
