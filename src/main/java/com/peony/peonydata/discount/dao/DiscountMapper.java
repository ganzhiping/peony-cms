package com.peony.peonydata.discount.dao;

import java.util.List;

import com.peony.peonydata.discount.model.Discount;

public interface DiscountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Discount record);

    int insertSelective(Discount record);

    Discount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Discount record);

    int updateByPrimaryKey(Discount record);
    /**
     * 查询折扣列表分页
     * @param discount
     * @return
     */
    List<Discount> selectByPage(Discount discount);
}