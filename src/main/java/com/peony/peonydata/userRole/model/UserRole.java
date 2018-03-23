package com.peony.peonydata.userRole.model;

import com.peony.core.base.pojo.BasePojo;
import com.peony.peonydata.role.model.Role;
import com.peony.peonydata.user.model.User;

public class UserRole extends BasePojo{
    private Integer userId;

    private Integer roleId;
    
    
    private String roleIds;//批量更新时用
    
    private String userIds;//批量更新时用
    
    private String pre_userIds;//批量更新时用
    

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public String getPre_userIds() {
		return pre_userIds;
	}

	public void setPre_userIds(String pre_userIds) {
		this.pre_userIds = pre_userIds;
	}
    
	
}