package com.peony.peonydata.subjectpage.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.subjectpage.model.SubjectPage;

public interface SubjectPageService {

	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<SubjectPage> selectByPage(SubjectPage record);
	
	
	int deleteByPrimaryKey(String [] ids);
	
	
	/**
	 * 设置正负面
	 * @param ids
	 * @param polarity
	 * @return
	 */
	int updateSubjectPageState(String [] ids,Integer polarity);
	
	
    SubjectPage selectByPrimaryKey(String id);
}
