package com.peony.peonydata.operationlog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.PageParameter;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.operationlog.dao.OperationLogMapper;
import com.peony.peonydata.operationlog.model.OperationLog;

/**
 * 操作日志
 *
 * @author jhj
 * @version 1
 */
@Service
public class OperationLogServiceImpl implements OperationLogService {

    @Resource
    private OperationLogMapper operationLogMapper;

    @Override
    public List<OperationLog> selectOperationLogsByLoginCounts() {
        return this.operationLogMapper.selectOperationLogsByLoginCounts();
    }

    @Override
    public List<OperationLog> selectOperationLogsByModuleCounts() {
        return this.operationLogMapper.selectOperationLogsByModuleCounts();
    }

    @Override
    public Pagination<OperationLog> selectByPage(OperationLog record) {
        List<OperationLog> list = this.operationLogMapper.selectByPage(record);
        return new Pagination<OperationLog>(list, record.getPageParameter());
    }

    @Override
    public List<OperationLog> selectEbookOperationLoginLogsByajax() {
        return this.operationLogMapper.selectEbookOperationLoginLogsByajax();
    }

    @Override
    public List<OperationLog> selectEbookOperationHotNewsLogsByajax() {
        OperationLog operationLog = new OperationLog();
        PageParameter pageParameter = new PageParameter();
        pageParameter.setPageSize(15);
        pageParameter.setCurrentPage(1);
        operationLog.setPageParameter(pageParameter);
        List<OperationLog> list = this.operationLogMapper.selectEbookOperationHotNewsLogsByajaxByPage(operationLog);
        return list;
    }

}
