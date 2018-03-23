package com.peony.peonydata.ebinfolog.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.ebinfolog.model.EbInfoLog;

public interface EbInfoLogService {

	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<EbInfoLog> selectByPage(EbInfoLog record);
	
	/**
	 * 信息日志前十条点击转发收藏统计
	 * @return
	 */
	List<EbInfoLog> selectEbInfoLogsByAjax();
	
	/**
	 * 信息来源统计
	 * @return
	 */
	List<EbInfoLog> selectEbInfoLogsByAjaxAndType();
	
	/**
	 * 模块点击量统计
	 * @return
	 */
	List<EbInfoLog> selectEbInfoLogsByAjaxAndModule();
	
	/**
	 * 模块转发收藏量统计
	 * @return
	 */
	List<EbInfoLog> selectEbInfoLogsByAjaxAndModuleAndForwardsCollects();
 
}
