package com.peony.peonydata.pointsexchange.dao;

import java.util.List;

import com.peony.peonydata.pointsexchange.model.PointsExchange;

public interface PointsExchangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PointsExchange record);

    int insertSelective(PointsExchange record);

    PointsExchange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PointsExchange record);

    int updateByPrimaryKey(PointsExchange record);
    /**
     * 查询积分兑换列表（分页）
     * @param record
     * @return
     */
    List<PointsExchange> selectByPage(PointsExchange record);
}