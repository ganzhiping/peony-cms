package com.peony.peonydata.userRole.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peony.core.base.controller.BaseController;
import com.peony.peonydata.userRole.model.UserRole;
import com.peony.peonydata.userRole.service.UserRoleService;

/**
 * 用户-角色关联
 * @date 
 * @author jhj
 * @version 1
 */

@Controller
@RequestMapping("/userRole")
public class UserRoleController extends BaseController {

	@Autowired
	private UserRoleService userRoleService; // 用户-角色服务接口
	
	/**
	 * 保存增加 user-role
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/saveUserRole")
	@ResponseBody
	public String saveUserRole(@ModelAttribute("userRole") UserRole userRole) {
		this.userRoleService.saveUserRole(userRole);
		return "";
	}

	/**
	 * 删除用户-角色关联
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteUserRole")
	@ResponseBody
	public String deleteUserRole(@ModelAttribute("userRole") UserRole userRole) {
		this.userRoleService.deleteByRoleIdAndUserId(userRole);
		return "";
	}
	

	/**
	 * 更新用户-角色关联
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateUserRole")
	@ResponseBody
	public String updateUserRole(@ModelAttribute("userRole") UserRole userRole) {
		this.userRoleService.updateUserRole(userRole);
		return "";
	}
}
