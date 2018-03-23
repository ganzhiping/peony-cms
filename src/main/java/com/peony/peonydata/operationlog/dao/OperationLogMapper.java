package com.peony.peonydata.operationlog.dao;

import java.util.List;

import com.peony.peonydata.operationlog.model.OperationLog;

public interface OperationLogMapper {
  
	List<OperationLog> selectOperationLogs(OperationLog operationLog);
	
	List<OperationLog> selectOperationLogsByLoginCounts();
	
	List<OperationLog> selectOperationLogsByModuleCounts();
	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	List<OperationLog> selectByPage(OperationLog record);
	
	List<OperationLog> selectEbookOperationLoginLogsByajax();
	
	List<OperationLog> selectEbookOperationHotNewsLogsByajaxByPage(OperationLog operationLog);
	
}