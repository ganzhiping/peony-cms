package com.peony.peonydata.seller.service;

import java.util.List;

import com.peony.peonydata.seller.model.Seller;

public interface SellerService {
	/**
	 * 通过管理者id查询管理关系 不分页
	 * @param roleId
	 * @return
	 */
	List <Seller> selectByManagerId(Seller record);
	
	int updateSeller(Seller record);
	
}
