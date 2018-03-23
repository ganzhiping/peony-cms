package com.peony.peonydata.message.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.information.model.Information;
import com.peony.peonydata.message.model.Message;

public interface MessageService {

	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<Message> selectByPage(Message record);
	/**
	 * 获取列表 无分页
	 * @return
	 */
	List<Message> selectMessages();
	/**
	 * 根据主键删除
	 * 
	 * @param messageId
	 * @return
	 */
	int deleteByPrimaryKey(Integer messageId);

	/**
	 * 插入
	 * 
	 * @param 
	 * @return
	 */
	int insert(Message record);

	/**
	 * 插入选择数据
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(Message record);

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	Message selectByPrimaryKey(Integer id);

	/**
	 * 根据主键选择更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Message record);

	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Message record);
}
