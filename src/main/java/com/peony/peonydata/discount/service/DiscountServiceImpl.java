package com.peony.peonydata.discount.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.discount.dao.DiscountMapper;
import com.peony.peonydata.discount.model.Discount;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Resource
    private DiscountMapper discountMapper;

    @Override
    public Pagination<Discount> selectByPage(Discount discount) {
        List<Discount> list = this.discountMapper.selectByPage(discount);
        return new Pagination<Discount>(list, discount.getPageParameter());
    }

    @Override
    public int insertSelective(Discount discount) {
        return this.discountMapper.insertSelective(discount);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.discountMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Discount selectByPrimaryKey(Integer id) {
        return this.discountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Discount record) {
        return this.discountMapper.updateByPrimaryKeySelective(record);
    }

}
