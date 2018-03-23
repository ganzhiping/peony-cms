package com.peony.peonydata.operationlog.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.apply.model.Apply;
import com.peony.peonydata.information.model.Information;
import com.peony.peonydata.message.model.Message;
import com.peony.peonydata.operationlog.model.OperationLog;

public interface OperationLogService {

	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<OperationLog> selectByPage(OperationLog record);
    List<OperationLog> selectOperationLogsByLoginCounts();
	List<OperationLog> selectOperationLogsByModuleCounts();
	/**
	 * E人E本登录统计
	 * @return
	 */
	List<OperationLog> selectEbookOperationLoginLogsByajax();
	/**
	 * E人E本热点新闻点击数统计
	 * @return
	 */
	List<OperationLog> selectEbookOperationHotNewsLogsByajax();
	
}
