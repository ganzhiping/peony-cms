package com.peony.peonydata.website.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.website.dao.WebSiteMapper;
import com.peony.peonydata.website.model.WebSite;

@Service
public class WebSiteServiceImpl implements WebSiteService {
    @Resource
    private WebSiteMapper webSiteMapper;

    @Override
    public Pagination<WebSite> selectByPage(WebSite record) {
        List<WebSite> list = this.webSiteMapper.selectByPage(record);
        return new Pagination<WebSite>(list, record.getPageParameter());
    }

    @Override
    public int deleteByPrimaryKey(Integer websiteId) {
        return this.webSiteMapper.deleteByPrimaryKey(websiteId);
    }

    @Override
    public int insert(WebSite record) {
        return this.webSiteMapper.insert(record);
    }

    @Override
    public int insertSelective(WebSite record) {
        return this.webSiteMapper.insertSelective(record);
    }

    @Override
    public WebSite selectByPrimaryKey(Integer websiteId) {
        return this.webSiteMapper.selectByPrimaryKey(websiteId);
    }

    @Override
    public int updateByPrimaryKeySelective(WebSite record) {
        return this.webSiteMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WebSite record) {
        return this.webSiteMapper.updateByPrimaryKey(record);
    }

}
