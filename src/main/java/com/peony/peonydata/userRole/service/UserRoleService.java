package com.peony.peonydata.userRole.service;

import com.peony.peonydata.userRole.model.UserRole;

/**
 * 用户-角色关联service接口
 * 
 * @date：
 * @author jhj
 * @version 1
 */
public interface UserRoleService {
	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	int insert(UserRole record);

	/**
	 * 插入选择
	 * @param record
	 * @return
	 */
	int insertSelective(UserRole record);

	/**
	 * 删除
	 * @param record
	 * @return
	 */
	int deleteByRoleIdAndUserId(UserRole record);
	
	
	/**通过userId删除
	 * @param record
	 * @return
	 */
	int deleteByUserId(Integer userId);
	
	int deleteByRoleId(Integer roleId);
	
	int updateUserRole(UserRole record);
	
	
	int saveUserRole(UserRole record);

}
