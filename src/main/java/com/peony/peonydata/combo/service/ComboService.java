package com.peony.peonydata.combo.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.combo.model.Combo;

public interface ComboService {
	/**
	 * 查询套餐列表
	 * @return
	 */
	List<Combo> selectComboList();
	/**
	 * 查询套餐列表(查询所有套餐)
	 * @return
	 */
	List<Combo> selectAllCombos();
	/**
	 * 查询套餐带分页
	 * @param combo
	 * @return
	 */
	Pagination<Combo> selectByPage( Combo combo);
	/**
	 * 保存套餐
	 * @param combo
	 * @return
	 */
	int insertSelective(Combo combo);
	/**
	 * 更新套餐
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Combo record);
	/**
	 * 根据id查询套餐
	 * @param Id
	 * @return
	 */
	Combo selectByPrimaryKey(Integer Id);
}
