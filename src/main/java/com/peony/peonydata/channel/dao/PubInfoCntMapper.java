package com.peony.peonydata.channel.dao;

import java.util.List;

import com.peony.peonydata.channel.model.PubInfoCnt;

public interface PubInfoCntMapper {
    int deleteByPrimaryKey(Integer pubinfoId);

    int insert(PubInfoCnt record);

    int insertSelective(PubInfoCnt record);

    PubInfoCnt selectByPrimaryKey(Integer pubinfoId);

    int updateByPrimaryKeySelective(PubInfoCnt record);

    int updateByPrimaryKey(PubInfoCnt record);
    List<PubInfoCnt> selectPubinfoCnts();
}