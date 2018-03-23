package com.peony.peonydata.pointschange.dao;

import java.util.List;

import com.peony.peonydata.pointschange.model.PointsChange;

public interface PointsChangeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PointsChange record);

    int insertSelective(PointsChange record);

    PointsChange selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PointsChange record);

    int updateByPrimaryKey(PointsChange record);
    
    List<PointsChange> selectPointsChangesByPage(PointsChange pointschange);
}