package com.peony.peonydata.pointschange.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.pointschange.dao.PointsChangeMapper;
import com.peony.peonydata.pointschange.model.PointsChange;

@Service
public class PointsChangeServiceImpl implements PointsChangeService {
    @Resource
    private PointsChangeMapper pointsChangeMapper;

    @Override
    public Pagination<PointsChange> selectPointsChangesByPage(PointsChange pointschange) {
        List<PointsChange> list = this.pointsChangeMapper.selectPointsChangesByPage(pointschange);
        return new Pagination<PointsChange>(list, pointschange.getPageParameter());
    }

}
