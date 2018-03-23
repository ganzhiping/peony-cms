package com.peony.peonydata.channel.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peony.peonydata.baseclass.model.BaseClass;
import com.peony.peonydata.channel.model.Channel;

public interface ChannelService {
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
		List<Channel> findChildren(@Param(value = "parentCode") String parentCode);

		/**
		 * 是否有子节点
		 * @param parentCode
		 * @return
		 */
		boolean loadHasChildren(@Param(value = "parentCode") String parentCode);

	
		/**
		 * 查询所有
		 * @return
		 */
		List<Channel> selectChannels();
		
}
