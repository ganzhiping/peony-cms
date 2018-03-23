package com.peony.peonydata.apply.dao;

import java.util.List;

import com.peony.peonydata.apply.model.Apply;

public interface ApplyMapper {
    int deleteByPrimaryKey(Integer applyId);

    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer applyId);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
    
    List<Apply> selectApplys(Apply apply);
	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	List<Apply> selectByPage(Apply record);
    
}