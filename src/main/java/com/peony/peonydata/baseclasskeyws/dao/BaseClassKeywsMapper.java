package com.peony.peonydata.baseclasskeyws.dao;

import java.util.List;

import com.peony.peonydata.baseclasskeyws.model.BaseClassKeyws;

public interface BaseClassKeywsMapper {

	List<BaseClassKeyws> selectByPage(BaseClassKeyws record);
	List<BaseClassKeyws> selectBaseClassKeywsByBaseClassId(Integer id);
	
    int deleteByPrimaryKey(Integer id);

    int insert(BaseClassKeyws record);

    int insertSelective(BaseClassKeyws record);

    BaseClassKeyws selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseClassKeyws record);

    int updateByPrimaryKey(BaseClassKeyws record);
}