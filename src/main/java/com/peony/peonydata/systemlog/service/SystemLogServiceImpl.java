package com.peony.peonydata.systemlog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.systemlog.dao.SystemLogMapper;
import com.peony.peonydata.systemlog.model.SystemLog;

@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.systemLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SystemLog record) {
        return this.systemLogMapper.insert(record);
    }

    @Override
    public int insertSelective(SystemLog record) {
        return this.systemLogMapper.insertSelective(record);
    }

    @Override
    public SystemLog selectByPrimaryKey(Integer id) {
        return this.systemLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SystemLog record) {
        return this.systemLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SystemLog record) {
        return this.systemLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<SystemLog> selectByPage(SystemLog record) {
        List<SystemLog> list = this.systemLogMapper.selectByPage(record);
        return new Pagination<SystemLog>(list, record.getPageParameter());
    }

}
