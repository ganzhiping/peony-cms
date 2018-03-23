package com.peony.peonydata.seller.model;

public class Seller {
    private Integer managerUserId;

    private Integer userId;
    
    private String userIds;//授权时候用 用来授权的用户们


    public Integer getManagerUserId() {
        return managerUserId;
    }

    public void setManagerUserId(Integer managerUserId) {
        this.managerUserId = managerUserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
    
}