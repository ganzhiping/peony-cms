package com.peony.peonydata.warning.dao;

import java.util.List;

import com.peony.peonydata.warning.model.Warning;

public interface WarningMapper {
    int deleteByPrimaryKey(Integer warningId);

    int insert(Warning record);

    int insertSelective(Warning record);

    Warning selectByPrimaryKey(Integer warningId);

    int updateByPrimaryKeySelective(Warning record);

    int updateByPrimaryKey(Warning record);
    
	List<Warning> selectByPage(Warning record);
	
}