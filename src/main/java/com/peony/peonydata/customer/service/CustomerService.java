package com.peony.peonydata.customer.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.userRegion.model.UserRegion;
import com.peony.peonydata.userbaseclass.model.UserBaseClass;

public interface CustomerService {

	/**
	 * 保存客户
	 * @param user
	 * @param userBaseClass
	 * @param userRegion
	 * @return
	 */
	int insertSelective(User user,UserBaseClass userBaseClass,UserRegion userRegion);
	
	
	/**
	 * 更新客户
	 * @param user
	 * @param userBaseClass
	 * @param userRegion
	 * @return
	 */
	int updateSelective(User user,UserBaseClass userBaseClass,UserRegion userRegion);
	/**
	 * 查询免费移动版用户 分页
	 * @param user
	 * @return
	 */
	Pagination<User> selectMobileByPage(User user);
	
}
