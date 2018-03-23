package com.peony.peonydata.region.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peony.peonydata.region.model.RegionKeywords;

public interface RegionKeywordsMapper {
    int deleteByPrimaryKey(String regionid);

    int insert(RegionKeywords record);

    int insertSelective(RegionKeywords record);

    RegionKeywords selectByPrimaryKey(String regionid);

    int updateByPrimaryKeySelective(RegionKeywords record);

    int updateByPrimaryKey(RegionKeywords record);
    /**
     * 查询该地域及该地域以下的地域关键词
     * @param regionid
     * @return
     */
    List<RegionKeywords>selectByRegionId(@Param(value = "regionid")String regionid);
}