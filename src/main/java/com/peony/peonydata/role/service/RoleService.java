package com.peony.peonydata.role.service;

import java.util.List;
import java.util.Map;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.role.model.Role;

/**
 * 角色管理service接口
 * 
 * @date：2013-12-26 下午03:26:29
 * @author zhaoshutao@dongao.com
 * @version 1
 */
public interface RoleService {

	/**
	 * 编辑角色
	 * 
	 * @param user
	 * @return
	 */
	public void editRole(Role record);

	/**
	 * 角色列表无分页
	 */
	public List<Role> selectRoles();

	/**
	 * 查询角色列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<Role> selectByPage(Role record);

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
	 * @param userId
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
	 * 通过userId查询用角色不分页
	 * @param userId
	 * @return
	 */
	List<Role> selectByUserId(Integer userId);
}
