package com.peony.peonydata.information.dao;

import java.util.List;

import com.peony.peonydata.information.model.Information;
import com.peony.peonydata.user.model.User;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer informationId);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer informationId);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
    
    List<Information> selectInformations();
	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	List<Information> selectByPage(Information record);
}