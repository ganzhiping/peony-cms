package com.peony.peonydata.pointsexchange.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.pointsexchange.dao.PointsExchangeMapper;
import com.peony.peonydata.pointsexchange.model.PointsExchange;

@Service
public class PointsExchangeServiceImpl implements PointsExchangeService {
    @Resource
    private PointsExchangeMapper pointsExchangeMapper;

    @Override
    public Pagination<PointsExchange> selectByPage(PointsExchange record) {
        List<PointsExchange> list = this.pointsExchangeMapper.selectByPage(record);
        return new Pagination<PointsExchange>(list, record.getPageParameter());
    }

    @Override
    public int insertSelective(PointsExchange record) {
        return this.pointsExchangeMapper.insertSelective(record);
    }

    @Override
    public PointsExchange selectByPrimaryKey(Integer id) {
        return this.pointsExchangeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PointsExchange record) {
        return this.pointsExchangeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.pointsExchangeMapper.deleteByPrimaryKey(id);
    }

}
