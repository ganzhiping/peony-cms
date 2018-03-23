package com.peony.peonydata.operationlog.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.operationlog.model.EbOperation;

public interface EbOperationService {

	/**
	 * 查询列表 分页
	 * @param record
	 * @return
	 */
	Pagination<EbOperation> selectByPage(EbOperation record);
	
	
	
}
