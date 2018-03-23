package com.peony.peonydata.channel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.channel.dao.PubInfoCntMapper;
import com.peony.peonydata.channel.dao.PubInfoMapper;
import com.peony.peonydata.channel.model.PubInfo;
import com.peony.peonydata.channel.model.PubInfoCnt;

@Service
public class PubInfoServiceImpl implements PubInfoService {

    @Resource
    private PubInfoMapper    pubInfoMapper;

    @Resource
    private PubInfoCntMapper pubInfoCntMapper;

    @Override
    public int deleteByPrimaryKey(Integer pubinfoId) {
        this.pubInfoCntMapper.deleteByPrimaryKey(pubinfoId);
        return this.pubInfoMapper.deleteByPrimaryKey(pubinfoId);
    }

    @Override
    public int insert(PubInfo record) {
        return this.pubInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(PubInfo record) {
        PubInfoCnt cnt = new PubInfoCnt();
        cnt.setContent(record.getContent());
        cnt.setPubinfoId(record.getPubinfoId());
        this.pubInfoCntMapper.insertSelective(cnt);
        return this.pubInfoMapper.insertSelective(record);
    }

    @Override
    public PubInfo selectByPrimaryKey(Integer pubinfoId) {
        return this.pubInfoMapper.selectByPrimaryKey(pubinfoId);
    }

    @Override
    public int updateByPrimaryKeySelective(PubInfo record) {
        PubInfoCnt cnt = new PubInfoCnt();
        cnt.setContent(record.getContent());
        cnt.setPubinfoId(record.getPubinfoId());
        this.pubInfoCntMapper.updateByPrimaryKeySelective(cnt);
        return this.pubInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateBySelective(PubInfo record) {
        return this.pubInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PubInfo record) {
        return this.pubInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<PubInfo> selectByPage(PubInfo record) {
        List<PubInfo> list = this.pubInfoMapper.selectByPage(record);
        return new Pagination<PubInfo>(list, record.getPageParameter());
    }

}
