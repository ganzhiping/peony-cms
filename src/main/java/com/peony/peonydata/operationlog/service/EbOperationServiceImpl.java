package com.peony.peonydata.operationlog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.operationlog.dao.EbOperationMapper;
import com.peony.peonydata.operationlog.model.EbOperation;

/**
 * 操作日志
 */
@Service
public class EbOperationServiceImpl implements EbOperationService {

    @Resource
    private EbOperationMapper EboperationMapper;

    @Override
    public Pagination<EbOperation> selectByPage(EbOperation record) {
        List<EbOperation> list = this.EboperationMapper.selectByPage(record);
        return new Pagination<EbOperation>(list, record.getPageParameter());
    }

}
