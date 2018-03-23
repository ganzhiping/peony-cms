package com.peony.peonydata.systemlog.dao;

import java.util.List;

import com.peony.peonydata.systemlog.model.SystemLog;

public interface SystemLogMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    SystemLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);
    
    List<SystemLog> selectByPage(SystemLog record);
}