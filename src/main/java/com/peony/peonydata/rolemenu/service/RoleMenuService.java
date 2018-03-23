package com.peony.peonydata.rolemenu.service;

import com.peony.peonydata.rolemenu.model.RoleMenu;

/**
 * 角色-菜单关联service接口
 * 
 * @date：
 * @author jhj
 * @version 1
 */
public interface RoleMenuService {
	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	int insert(RoleMenu record);

	/**
	 * 插入选择
	 * @param record
	 * @return
	 */
	int insertSelective(RoleMenu record);

	/**
	 * 删除
	 * @param record
	 * @return
	 */
	int deleteByRoleIdAndMenuId(RoleMenu record);
	
	
	/**通过roleId删除 然后通过menuids 插入
	 * @param record
	 * @return
	 */
	int updateRoleMenu(RoleMenu record);

}
