package com.peony.peonydata.points.dao;

import java.util.List;

import com.peony.peonydata.points.model.Points;

public interface PointsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Points record);

    int insertSelective(Points record);

    Points selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Points record);

    int updateByPrimaryKey(Points record);
    
    List<Points> selectAllByPage(Points points);
}