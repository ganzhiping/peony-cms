package com.peony.peonydata.userRegion.service;

import java.util.List;

import com.peony.peonydata.userRegion.model.UserRegion;

public interface UserRegionService {
	int insert(UserRegion record);

    int insertSelective(UserRegion record);
    
    int deleteByUserId(int userId);

    int deleteByUserIdAndRegionId(UserRegion record);
    List<UserRegion> findUserByRegionId(int regionId);
    List<UserRegion> findByUserId(int userId);
}
