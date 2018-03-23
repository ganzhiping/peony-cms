package com.peony.peonydata.channel.dao;

import java.util.List;

import com.peony.peonydata.channel.model.PubInfo;

public interface PubInfoMapper {
    int deleteByPrimaryKey(Integer pubinfoId);

    int insert(PubInfo record);

    int insertSelective(PubInfo record);

    PubInfo selectByPrimaryKey(Integer pubinfoId);

    int updateByPrimaryKeySelective(PubInfo record);

    int updateByPrimaryKey(PubInfo record);
    
    List<PubInfo> selectByPage(PubInfo record);
}