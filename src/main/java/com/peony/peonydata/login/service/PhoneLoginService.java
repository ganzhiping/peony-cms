package com.peony.peonydata.login.service;

import java.util.List;

import com.peony.peonydata.login.model.PhoneLogin;

public interface PhoneLoginService {
	List<PhoneLogin> selectByUserId(PhoneLogin phoneLogin);
}
