package com.peony.peonydata.operationlog.dao;

import java.util.List;

import com.peony.peonydata.operationlog.model.EbOperation;

public interface EbOperationMapper {

    int insert(EbOperation record);
    int insertSelective(EbOperation record);
    int updateByPrimaryKeySelective(EbOperation record);

    int updateByPrimaryKey(EbOperation record);
    
    
	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	List<EbOperation> selectByPage(EbOperation record);
}