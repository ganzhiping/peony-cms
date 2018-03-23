package com.peony.peonydata.userserve.service;

import com.peony.peonydata.userserve.model.UserServe;

public interface UserServeService {

	    UserServe selectByUserId(Integer id);
	    int insert(UserServe record);

	    int insertSelective(UserServe record);

	    UserServe selectByPrimaryKey(Integer userserviceId);

	    int updateByPrimaryKeySelective(UserServe record);

	    /**
	     * 免费移动端
	     * @param record
	     * @return
	     */
	    int updateMobileByPrimaryKeySelective(UserServe record);

	    
	    //只更新userServe
	    int updateByKeySelective(UserServe record);


	    int updateByPrimaryKey(UserServe record);
	    /**
	     * 免费移动端
	     * @param record
	     * @return
	     */
	    int insertMobileSelective(UserServe record);
}
