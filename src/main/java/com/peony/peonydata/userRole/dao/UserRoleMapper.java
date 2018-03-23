package com.peony.peonydata.userRole.dao;

import com.peony.peonydata.userRole.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
    
    int deleteByRoleIdAndUserId(UserRole record);
    
    int deleteByUserId(Integer userId);
    
    int deleteByRoleId(Integer roleId);
}