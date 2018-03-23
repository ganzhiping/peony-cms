package com.peony.peonydata.role.model;

import java.util.Date;
import java.util.List;

import com.peony.core.base.pojo.BasePojo;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.userRole.model.UserRole;

public class Role extends BasePojo {
	private Integer roleId;

	private String name;

	private String deptId;

	private Date createTime;
	private String orderFields;
	private String order;
	
	
	//private Integer userId;//查询分页使用
	

	public String getOrderFields() {
		return orderFields;
	}

	public void setOrderFields(String orderFields) {
		this.orderFields = orderFields;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Role() {
	}

	public Role(Integer roleId, String name, String deptId, Date createTime,
			String orderFields, String order) {
		this.roleId = roleId;
		this.name = name;
		this.deptId = deptId;
		this.createTime = createTime;
		this.orderFields = orderFields;
		this.order = order;
	}
}