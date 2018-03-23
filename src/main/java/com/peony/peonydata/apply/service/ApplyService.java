package com.peony.peonydata.apply.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.apply.model.Apply;

public interface ApplyService {

	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<Apply> selectByPage(Apply record);
	
	
	/**
	 * 根据主键删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 插入
	 * 
	 * @param 
	 * @return
	 */
	int insert(Apply record);

	
	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	Apply selectByPrimaryKey(Integer id);

	
	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Apply record);
	
	/**
	 * 更新实体对象中非空字段
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Apply record);
}
