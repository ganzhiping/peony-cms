package com.peony.peonydata.salescount.dao;

import java.util.List;

import com.peony.peonydata.salescount.model.Records;

public interface RecordsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Records record);

    int insertSelective(Records record);

    Records selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Records record);

    int updateByPrimaryKey(Records record);
    /**
     * 查询销售统计
     * @param record
     * @return
     */
    List<Records> selectSalesCountByPage(Records record);
    /**
     * 查询套餐下的销售明细
     * @param record
     * @return
     */
    List<Records> selectSalesCountByComboidByPage(Records record);
}