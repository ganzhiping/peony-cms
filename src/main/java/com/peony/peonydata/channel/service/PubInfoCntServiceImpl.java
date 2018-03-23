package com.peony.peonydata.channel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.channel.dao.PubInfoCntMapper;
import com.peony.peonydata.channel.model.PubInfoCnt;

@Service
public class PubInfoCntServiceImpl implements PubInfoCntService {
    @Resource
    private PubInfoCntMapper pubInfoCntMapper;

    @Override
    public int deleteByPrimaryKey(Integer pubinfoId) {
        return this.pubInfoCntMapper.deleteByPrimaryKey(pubinfoId);
    }

    @Override
    public int insert(PubInfoCnt record) {
        return this.pubInfoCntMapper.insert(record);
    }

    @Override
    public int insertSelective(PubInfoCnt record) {
        return this.pubInfoCntMapper.insertSelective(record);
    }

    @Override
    public PubInfoCnt selectByPrimaryKey(Integer pubinfoId) {
        return this.pubInfoCntMapper.selectByPrimaryKey(pubinfoId);
    }

    @Override
    public int updateByPrimaryKeySelective(PubInfoCnt record) {
        return this.pubInfoCntMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PubInfoCnt record) {
        return this.pubInfoCntMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<PubInfoCnt> selectPubinfoCnts() {
        return this.pubInfoCntMapper.selectPubinfoCnts();
    }

}
