package com.peony.peonydata.userRegion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peony.peonydata.userRegion.model.UserRegion;

public interface UserRegionMapper {
    int insert(UserRegion record);

    int insertSelective(UserRegion record);
    
    int deleteByUserId(int userId);
    
    int deleteByUserIdAndRegionId(UserRegion record);
    
    List<UserRegion> findUserByRegionId(int regionId);
    
    List<UserRegion> findByUserId(@Param(value = "userId") int userId);
    
    
}