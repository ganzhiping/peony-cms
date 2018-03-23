package com.peony.peonydata.channel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peony.peonydata.channel.model.Channel;

public interface ChannelMapper {
    int deleteByPrimaryKey(Integer channelId);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer channelId);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
	/**
	 * 查询下级
	 * 
	 * @param parentCode
	 * @return
	 */
	List<Channel> selectChildren(@Param(value = "parentCode") String parentCode);

	/**
	 * 是否有用户
	 * 
	 * @param parentCode
	 * @return
	 */
	int loadHasChildren(@Param(value = "parentCode") String parentCode);

	/**
	 * 查询全部
	 * @return
	 */
	List<Channel> selectChannels();
}