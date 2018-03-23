package com.peony.peonydata.systemlog.service;

import com.peony.core.base.pojo.PageParameter;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.util.log.SysLog;

/**
 * 系统日志服务接口
 *
 * @date 2013-11-15 下午03:51:11
 * @author zhaoshutao
 * @version 1
 */
public interface SysLogService {

    /**
     * 保存系统日志
     *
     * @param sysLog
     */
    public void saveSysLog(SysLog sysLog);

    /**
     * 根据查询条件查询系统日志
     *
     * @param pageParameter
     * @return
     */
    public Pagination<SysLog> findAll(PageParameter pageParameter);

}
