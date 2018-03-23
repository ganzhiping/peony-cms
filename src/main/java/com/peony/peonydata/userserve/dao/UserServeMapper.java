package com.peony.peonydata.userserve.dao;

import com.peony.peonydata.userserve.model.UserServe;

public interface UserServeMapper {
    int deleteByPrimaryKey(Integer userserviceId);
    
    UserServe selectByUserId(Integer id);

    int insert(UserServe record);

    int insertSelective(UserServe record);

    UserServe selectByPrimaryKey(Integer userserviceId);

    int updateByPrimaryKeySelective(UserServe record);

    int updateByPrimaryKey(UserServe record);
}