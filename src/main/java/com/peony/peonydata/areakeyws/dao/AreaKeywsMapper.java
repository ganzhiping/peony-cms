package com.peony.peonydata.areakeyws.dao;

import java.util.List;

import com.peony.peonydata.areakeyws.model.AreaKeyws;

public interface AreaKeywsMapper {
	
	List<AreaKeyws> selectByPage(AreaKeyws record);
	List<AreaKeyws> selectAreakeywsByAreaId(Integer areaId);
	
    int deleteByPrimaryKey(Integer areaKeywsId);

    int insert(AreaKeyws record);

    int insertSelective(AreaKeyws record);

    AreaKeyws selectByPrimaryKey(Integer areaKeywsId);

    int updateByPrimaryKeySelective(AreaKeyws record);

    int updateByPrimaryKey(AreaKeyws record);
}