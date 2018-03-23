package com.peony.peonydata.website.dao;

import java.util.List;

import com.peony.peonydata.website.model.WebSite;

public interface WebSiteMapper {
    int deleteByPrimaryKey(Integer websiteId);

    int insert(WebSite record);

    int insertSelective(WebSite record);

    WebSite selectByPrimaryKey(Integer websiteId);

    int updateByPrimaryKeySelective(WebSite record);

    int updateByPrimaryKey(WebSite record);
    
    
    List<WebSite> selectByPage(WebSite record);
    
    
}