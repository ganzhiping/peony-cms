package com.peony.peonydata.discount.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.discount.model.Discount;

public interface DiscountService {
	/**
	 * 查询套餐分页
	 * @param discount
	 * @return
	 */
	Pagination<Discount> selectByPage(Discount discount);
	/**
	 * 保存折扣
	 * @param discount
	 * @return
	 */
	int insertSelective(Discount discount);
	/**
	 * 删除折扣
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);
	/**
	 * 根据id查询折扣
	 * @param id
	 * @return
	 */
	 Discount selectByPrimaryKey(Integer id);
	 /**
	  * 修改折扣
	  * @param record
	  * @return
	  */
	 int updateByPrimaryKeySelective(Discount record);
}
