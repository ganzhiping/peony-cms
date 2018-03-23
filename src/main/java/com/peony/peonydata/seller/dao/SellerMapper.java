package com.peony.peonydata.seller.dao;

import java.util.List;

import com.peony.peonydata.seller.model.Seller;

/**
 * 市场人员管理关系
 * @author jhj
 */
public interface SellerMapper {
	
    int insert(Seller record);
    
    int insertSelective(Seller record);
    
    List<Seller> selectByManagerId(Seller record);
    
    int deleteByManagerUserId(int managerUserId);
}