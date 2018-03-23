package com.peony.peonydata.role.dao;

import java.util.List;
import com.peony.peonydata.role.model.Role;

public interface RoleMapper {
	/**
	 * 按主键删除
	 * 
	 * @param Id
	 * @return
	 */
	int deleteByPrimaryKey(Integer Id);

	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	int insert(Role record);

	/**
	 * 插入选择
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(Role record);

	/**
	 * 根据主键查询
	 * 
	 * @param Id
	 * @return
	 */
	Role selectByPrimaryKey(Integer Id);

	/**
	 * 更新选择
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Role record);

	/**
	 * 更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Role record);

	/**
	 * 查询列表 不分页
	 * 
	 * @param record
	 * @return
	 */
	List<Role> selectRoles();

	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	List<Role> selectByPage(Role record);
	
	
	/**
	 * 通过userId查询用角色分页
	 * @param userId
	 * @return
	 */
	List<Role> selectByUserId(Integer userId);

}