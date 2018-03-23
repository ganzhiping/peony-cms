package com.peony.peonydata.points.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.points.model.Points;

public interface PointsService {
	Pagination<Points> selectAllByPage(Points points);
	Points selectByPrimaryKey(Integer id);
	int updateByPrimaryKeySelective(Points record);
}
