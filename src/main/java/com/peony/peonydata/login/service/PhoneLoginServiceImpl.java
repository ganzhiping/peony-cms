package com.peony.peonydata.login.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.login.dao.PhoneLoginMapper;
import com.peony.peonydata.login.model.PhoneLogin;

@Service
public class PhoneLoginServiceImpl implements PhoneLoginService {

    @Resource
    private PhoneLoginMapper phoneLoginMapper;

    @Override
    public List<PhoneLogin> selectByUserId(PhoneLogin phoneLogin) {
        return this.phoneLoginMapper.selectByUserId(phoneLogin);
    }

}
