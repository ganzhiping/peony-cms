package com.peony.peonydata.user.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.user.model.User;

/**
 * 用户服务接口
 * 
 * @date 2013-10-24 下午05:42:49
 * @author zhaoshutao
 * @version 1
 */
public interface UserService {

	/**
	 * 根据登录名查询
	 * 
	 * @param loginName
	 * @return
	 */
	public List<User> selectUserByLoginName(String loginName);

	/**
	 * 编辑用户
	 * 
	 * @param user
	 * @return
	 */
	public void editUser(User user);

	/**
	 * 用户列表无分页
	 */
	public List<User> selectUsers(User user);

	List<User> selectByPopular(User record);
	/**
	 * 查询用户列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<User> selectByPage(User record);

	/**
	 * 通过roleId查询用户 分页
	 * @param roleId
	 * @return
	 */
	Pagination<User> selectByRoleIdPage(User user);
	
	
	/**
	 * 通过roleId查询用户不 分页
	 * @param roleId
	 * @return
	 */
	List <User> selectByRoleIdNoPage(User user);
	
	/**
	 * 通过市场管理者用户id查询 子市场用户 
	 * @param managerUserId
	 * @return
	 */
	List<User> selectByManagerId(Integer managerUserId);
	/**
	 * 按主键删除
	 * 
	 * @param userId
	 * @return
	 */
	int deleteByPrimaryKey(String userIds);

	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	int insert(User record);

	/**
	 * 插入选择
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(User record);

	/**
	 * 根据主键查询
	 * 
	 * @param userId
	 * @return
	 */
	User selectByPrimaryKey(Integer userId);

	/**
	 * 更新选择
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(User record);

	/**
	 * 更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(User record);
	/**
	 * 查询销售明细
	 * @param roleId
	 * @return
	 */
	Pagination <User> selectAllMobileSalesListByPage(User user);
}
