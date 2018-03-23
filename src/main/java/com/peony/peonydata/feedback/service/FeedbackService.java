package com.peony.peonydata.feedback.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.feedback.model.Feedback;

public interface FeedbackService {

	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<Feedback> selectByPage(Feedback record);
	/**
	 * 获取列表 无分页
	 * @return
	 */
	List<Feedback> selectFeedbacks();
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
	int insert(Feedback record);

	
	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	Feedback selectByPrimaryKey(Integer id);

	
	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Feedback record);
}
