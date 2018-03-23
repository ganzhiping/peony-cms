package com.peony.peonydata.information.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.information.model.Information;
import com.peony.peonydata.user.model.User;

public interface InformationService {

	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<Information> selectByPage(Information record);
	/**
	 * 获取列表 无分页
	 * @return
	 */
	List<Information> selectInformations();
	/**
	 * 根据主键删除
	 * 
	 * @param informationId
	 * @return
	 */
	int deleteByPrimaryKey(Integer informationId);

	/**
	 * 插入
	 * 
	 * @param 
	 * @return
	 */
	int insert(Information information);

	/**
	 * 插入选择数据
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(Information record);

	/**
	 * 根据主键查询
	 * 
	 * @param informationId
	 * @return
	 */
	Information selectByPrimaryKey(Integer informationId);

	/**
	 * 根据主键选择更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Information record);

	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Information record);
}
