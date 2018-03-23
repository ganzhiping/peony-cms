package com.peony.peonydata.systemlog.service;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.PageParameter;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.util.log.SysLog;

/**
 * 系统日志服务
 *
 * @date 2013-11-15 下午03:51:11
 * @author zhaoshutao
 * @version 1
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    // @Autowired
    // private MongoDBDao mongoDBDao;

    /**
     * 保存系统日志
     *
     * @param sysLog
     */
    @Override
    public void saveSysLog(SysLog sysLog) {
        // mongoDBDao.save(sysLog);
    }

    /**
     * 根据查询条件查询系统日志
     */
    @Override
    public Pagination<SysLog> findAll(PageParameter pageParameter) {
        return null;
        // long totalCount = mongoDBDao.findCount(SysLog.class, new Query());
        // <SysLog> sysLogs = mongoDBDao.findList(SysLog.class, new Query(),
        // pageParameter.getCurrentPage(), pageParameter.getPageSize());
        // pageParameter.setTotalCount(Long.valueOf(totalCount).intValue());

        // return new Pagination<SysLog>(sysLogs, pageParameter);
    }
}
