package com.peony.peonydata.user.dao;

import java.util.List;

import com.peony.peonydata.role.model.Role;
import com.peony.peonydata.user.model.User;

/**
 * 用户dao接口
 * 
 * @author lenovo41
 * @date 2014-5-9 下午4:08:25
 */
public interface UserMapper {
	/**
	 * 按主键删除
	 * 
	 * @param userId
	 * @return
	 */
	int deleteByPrimaryKey(Integer userId);

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
	 * 查询用户列表 不分页
	 * 
	 * @param record
	 * @return
	 */
	List<User> selectUsers(User user);

	/**
	 * 查询用户列表 分页
	 * 
	 * @param record
	 * @return
	 */
	List<User> selectByPage(User record);

	
	/**
	 * 通过roleId查询用户 分页
	 * @param 
	 * @return
	 */
	List<User> selectByRoleIdPage(User user);
	/**
	 * 根据用户登录名查询
	 * 
	 * @param loginName
	 * @return
	 */
	List<User> selectUserByLoginName(String loginName);
	
	
	/**
	 * 通过市场管理者用户id查询 子市场用户  
	 * @param managerUserId
	 * @return
	 */
	List<User> selectByManagerId(Integer managerUserId);
	/**
	 * 查询免费移动版用户 分页
	 * @param user
	 * @return
	 */
	List<User> selectMobileByPage(User user);
	/**
	 * 查询销售明细
	 * @param user
	 * @return
	 */
	List<User> selectAllMobileSalesListByPage(User user);

    List<User> selectByPopular(User record);
}