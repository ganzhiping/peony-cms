package com.peony.peonydata.pointsexchange.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.pointsexchange.model.PointsExchange;

public interface PointsExchangeService {
	/**
     * 查询积分兑换列表（分页）
     * @param record
     * @return
     */
	Pagination<PointsExchange> selectByPage(PointsExchange record);
	
	int insertSelective(PointsExchange record);
	
	PointsExchange selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(PointsExchange record);
	
	int deleteByPrimaryKey(Integer id);
}
