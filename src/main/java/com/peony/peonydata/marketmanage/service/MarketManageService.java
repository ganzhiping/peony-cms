package com.peony.peonydata.marketmanage.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.seller.model.Seller;
import com.peony.peonydata.user.model.User;

/**
 * 市场人员管理服务接口
 * @author jhj
 */
public interface MarketManageService {

	/**
	 * 查询用户列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<User> selectByPage(User record);
	
	
	int insertMarketUser(User record,Seller seller);
}
