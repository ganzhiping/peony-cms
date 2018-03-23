package com.peony.peonydata.warning.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.warning.model.Warning;

public interface WarningService {
	 int deleteByPrimaryKey(Integer warningId);

	    int insert(Warning record);

	    int insertSelective(Warning record);

	    Warning selectByPrimaryKey(Integer warningId);

	    int updateByPrimaryKeySelective(Warning record);

	    int updateByPrimaryKey(Warning record);
	    
		Pagination<Warning> selectByPage(Warning record);
}
