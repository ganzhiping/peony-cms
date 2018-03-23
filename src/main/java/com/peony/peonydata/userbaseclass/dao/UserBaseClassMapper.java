package com.peony.peonydata.userbaseclass.dao;

import com.peony.peonydata.userbaseclass.model.UserBaseClass;

public interface UserBaseClassMapper {
    int insert(UserBaseClass record);

    int insertSelective(UserBaseClass record);
    
    int deleteByUserIdAndBaseId(UserBaseClass record);
    
    int deleteByUserId(UserBaseClass record);
}