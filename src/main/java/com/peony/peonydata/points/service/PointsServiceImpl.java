package com.peony.peonydata.points.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.points.dao.PointsMapper;
import com.peony.peonydata.points.model.Points;

@Service
public class PointsServiceImpl implements PointsService {
    @Resource
    private PointsMapper pointsMapper;

    @Override
    public Pagination<Points> selectAllByPage(Points points) {
        List<Points> list = this.pointsMapper.selectAllByPage(points);
        return new Pagination<Points>(list, points.getPageParameter());
    }

    @Override
    public Points selectByPrimaryKey(Integer id) {
        return this.pointsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Points record) {

        return this.pointsMapper.updateByPrimaryKeySelective(record);
    }

}
