package com.peony.peonydata.systemlog.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.systemlog.model.SystemLog;

/**
 * 系统日志服务
 *
 * @author jhj
 */
public interface SystemLogService {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemLog record);

    int insertSelective(SystemLog record);

    SystemLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemLog record);

    int updateByPrimaryKey(SystemLog record);

    /**
     * 查询列表 分页
     *
     * @param record
     * @return
     */
    Pagination<SystemLog> selectByPage(SystemLog record);
}
