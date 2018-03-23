package com.peony.peonydata.salescount.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.salescount.dao.RecordsMapper;
import com.peony.peonydata.salescount.model.Records;

@Service
public class SalescountServiceImpl implements SalescountService {
    @Resource
    private RecordsMapper recordsMapper;

    @Override
    public Pagination<Records> selectSalesCountByPage(Records record) {
        List<Records> list = this.recordsMapper.selectSalesCountByPage(record);
        return new Pagination<Records>(list, record.getPageParameter());
    }

    @Override
    public Pagination<Records> selectSalesCountByComboidByPage(Records record) {
        List<Records> list = this.recordsMapper.selectSalesCountByComboidByPage(record);
        return new Pagination<Records>(list, record.getPageParameter());
    }

}
