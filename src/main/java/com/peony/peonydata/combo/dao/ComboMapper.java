package com.peony.peonydata.combo.dao;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.combo.model.Combo;

public interface ComboMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Combo record);

    int insertSelective(Combo record);

    Combo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Combo record);

    int updateByPrimaryKey(Combo record);
    /**
     * 查询全部套餐
     * @return
     */
    List<Combo> selectAllCombos();
    /**
     * 查询再用套餐
     * @return
     */
    List<Combo> selectComboList();
    /**
	 * 查询套餐带分页
	 * @param combo
	 * @return
	 */
	List<Combo> selectByPage( Combo combo);
}