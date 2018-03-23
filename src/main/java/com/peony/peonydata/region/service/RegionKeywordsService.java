package com.peony.peonydata.region.service;

import java.util.List;

import com.peony.peonydata.region.model.RegionKeywords;

public interface RegionKeywordsService {
	RegionKeywords selectByPrimaryKey(String regionid);
	 int updateByPrimaryKeySelective(RegionKeywords record);
	 /**
	     * 查询该地域及该地域以下的地域关键词
	     * @param regionid
	     * @return
	     */
	    List<RegionKeywords>selectByRegionId(String regionid);
}
