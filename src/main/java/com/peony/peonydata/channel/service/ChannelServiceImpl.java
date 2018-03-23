package com.peony.peonydata.channel.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.channel.dao.ChannelMapper;
import com.peony.peonydata.channel.model.Channel;

@Service
public class ChannelServiceImpl implements ChannelService {
    @Resource
    private ChannelMapper channelMapper;

    @Override
    public int deleteByPrimaryKey(Integer channelId) {
        return this.channelMapper.deleteByPrimaryKey(channelId);
    }

    @Override
    public int insert(Channel record) {
        return this.channelMapper.insert(record);
    }

    @Override
    public int insertSelective(Channel record) {
        return this.channelMapper.insertSelective(record);
    }

    @Override
    public Channel selectByPrimaryKey(Integer channelId) {
        return this.channelMapper.selectByPrimaryKey(channelId);
    }

    @Override
    public int updateByPrimaryKeySelective(Channel record) {
        return this.channelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Channel record) {
        return this.channelMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Channel> findChildren(String parentCode) {
        return this.channelMapper.selectChildren(parentCode);
    }

    @Override
    public List<Channel> selectChannels() {
        return this.channelMapper.selectChannels();
    }

    @Override
    public boolean loadHasChildren(String parentCode) {
        return this.channelMapper.loadHasChildren(parentCode) == 1;
    }

}
