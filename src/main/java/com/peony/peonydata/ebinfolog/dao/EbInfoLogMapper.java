package com.peony.peonydata.ebinfolog.dao;

import java.util.List;

import com.peony.peonydata.ebinfolog.model.EbInfoLog;
import com.peony.peonydata.ebinfolog.model.EbInfoLogKey;

public interface EbInfoLogMapper {
	
    int deleteByPrimaryKey(EbInfoLogKey key);

    int insert(EbInfoLog record);

    int insertSelective(EbInfoLog record);

    EbInfoLog selectByPrimaryKey(EbInfoLogKey key);

    int updateByPrimaryKeySelective(EbInfoLog record);

    int updateByPrimaryKey(EbInfoLog record);
    
	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	List<EbInfoLog> selectByPage(EbInfoLog record);
	
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