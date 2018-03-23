package com.peony.peonydata.key.dao;

import com.peony.peonydata.key.model.Id;

public interface IdMapper {
	int insert(Id record);

	int insertSelective(Id record);

	Id selectByPrimaryKey(String kId);

	int updateByPrimaryKeySelective(Id record);

}