package com.peony.peonydata.ebinfolog.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.BasePojo;
import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.ebinfolog.dao.EbInfoLogMapper;
import com.peony.peonydata.ebinfolog.model.EbInfoLog;

/**
 * 信息日志
 *
 * @author sjj
 * @version 1
 */
@Service
public class EbInfoLogServiceImpl implements EbInfoLogService {

    @Resource
    private EbInfoLogMapper ebInfoLogMapper;

    @Override
    public Pagination<EbInfoLog> selectByPage(EbInfoLog record) {
        List<EbInfoLog> list = this.ebInfoLogMapper.selectByPage(record);
        return new Pagination<EbInfoLog>(list, ((BasePojo) record).getPageParameter());
    }

    @Override
    public List<EbInfoLog> selectEbInfoLogsByAjax() {
        return this.ebInfoLogMapper.selectEbInfoLogsByAjax();
    }

    @Override
    public List<EbInfoLog> selectEbInfoLogsByAjaxAndType() {
        return this.ebInfoLogMapper.selectEbInfoLogsByAjaxAndType();
    }

    @Override
    public List<EbInfoLog> selectEbInfoLogsByAjaxAndModule() {
        return this.ebInfoLogMapper.selectEbInfoLogsByAjaxAndModule();
    }

    @Override
    public List<EbInfoLog> selectEbInfoLogsByAjaxAndModuleAndForwardsCollects() {
        return this.ebInfoLogMapper.selectEbInfoLogsByAjaxAndModuleAndForwardsCollects();
    }

}
