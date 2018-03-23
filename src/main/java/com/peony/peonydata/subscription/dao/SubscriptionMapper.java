package com.peony.peonydata.subscription.dao;

import org.apache.ibatis.annotations.Param;

import com.peony.peonydata.subscription.model.Subscription;

public interface SubscriptionMapper {
    int deleteByPrimaryKey(Integer subscriptionId);

    int insert(Subscription record);

    int insertSelective(Subscription record);

    Subscription selectByPrimaryKey(Integer subscriptionId);

    int updateByPrimaryKeySelective(Subscription record);

    int updateByPrimaryKey(Subscription record);
    
    int deleteByUserId(@Param(value = "userId") String userId);
}