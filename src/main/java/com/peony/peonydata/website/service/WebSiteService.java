package com.peony.peonydata.website.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.website.model.WebSite;

public interface WebSiteService {
	int deleteByPrimaryKey(Integer websiteId);

    int insert(WebSite record);

    int insertSelective(WebSite record);

    WebSite selectByPrimaryKey(Integer websiteId);

    int updateByPrimaryKeySelective(WebSite record);

    int updateByPrimaryKey(WebSite record);
	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<WebSite> selectByPage(WebSite record);
}
