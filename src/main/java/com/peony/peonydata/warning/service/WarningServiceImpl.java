package com.peony.peonydata.warning.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.warning.dao.WarningMapper;
import com.peony.peonydata.warning.model.Warning;

@Service
public class WarningServiceImpl implements WarningService {

    @Resource
    private WarningMapper warningMapper; // 预警服务mapper

    @Override
    public int deleteByPrimaryKey(Integer warningId) {
        return this.warningMapper.deleteByPrimaryKey(warningId);
    }

    @Override
    public int insert(Warning record) {
        return this.warningMapper.insert(record);
    }

    @Override
    public int insertSelective(Warning record) {
        return this.warningMapper.insertSelective(record);
    }

    @Override
    public Warning selectByPrimaryKey(Integer warningId) {
        return this.warningMapper.selectByPrimaryKey(warningId);
    }

    @Override
    public int updateByPrimaryKeySelective(Warning record) {
        return this.warningMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Warning record) {
        return this.warningMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<Warning> selectByPage(Warning record) {
        List<Warning> list = this.warningMapper.selectByPage(record);
        return new Pagination<Warning>(list, record.getPageParameter());
    }

}
