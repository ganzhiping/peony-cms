package com.peony.peonydata.rolemenu.dao;

import com.peony.peonydata.rolemenu.model.RoleMenu;

public interface RoleMenuMapper {
    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);
    
	/**
	 * 删除
	 * @param record
	 * @return
	 */
	int deleteByRoleIdAndMenuId(RoleMenu record);
	
	
	/**通过roleId删除 
	 * @param record
	 * @return
	 */
	int deleteByRoleId(RoleMenu record);
}