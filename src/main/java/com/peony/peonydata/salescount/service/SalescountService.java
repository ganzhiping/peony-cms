package com.peony.peonydata.salescount.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.salescount.model.Records;

public interface SalescountService {
	/**
     * 查询销售统计
     * @param record
     * @return
     */
	Pagination<Records> selectSalesCountByPage(Records record);
	  /**
     * 查询套餐下的销售明细
     * @param record
     * @return
     */
	Pagination<Records> selectSalesCountByComboidByPage(Records record);
}
