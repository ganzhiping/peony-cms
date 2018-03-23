package com.peony.peonydata.login.dao;

import java.util.List;

import com.peony.peonydata.login.model.PhoneLogin;

public interface PhoneLoginMapper {
   
    PhoneLogin selectByPrimaryKey(Integer id);
    List<PhoneLogin> selectByUserId (PhoneLogin phoneLogin);
}