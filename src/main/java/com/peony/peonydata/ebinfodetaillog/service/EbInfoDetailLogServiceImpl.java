package com.peony.peonydata.ebinfodetaillog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.ebinfodetaillog.dao.EbInfoDetailLogMapper;
import com.peony.peonydata.ebinfodetaillog.model.EbInfoDetailLog;

/**
 * 信息日志
 *
 * @author sjj
 * @version 1
 */
@Service
public class EbInfoDetailLogServiceImpl implements EbInfoDetailLogService {

    @Resource
    private EbInfoDetailLogMapper ebInfoDetailLogMapper;

    @Override
    public Pagination<EbInfoDetailLog> selectByPage(EbInfoDetailLog record) {
        List<EbInfoDetailLog> list = this.ebInfoDetailLogMapper.selectByPage(record);
        return new Pagination<EbInfoDetailLog>(list, record.getPageParameter());
    }

}
