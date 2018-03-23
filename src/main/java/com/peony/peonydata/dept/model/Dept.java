package com.peony.peonydata.dept.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

/**
 * 部门pojo
 * 
 * @author lenovo41
 * @date 2014-5-8 下午3:22:46
 */
public class Dept extends BasePojo {
	private Integer deptId;// 部门id

	private String name;// 部门名称

	private String deptPid;// 上级部门id

	private String code;// 编号

	private String area;// 地区

	private String type;// 类型

	private String order;// 排序

	private Date creatTime;// 创建 时间

	private String head;// 法人代表

	private String address;// 地域

	private String mobile;// 电话

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptPid() {
		return deptPid;
	}

	public void setDeptPid(String deptPid) {
		this.deptPid = deptPid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Dept(Integer deptId, String name, String deptPid, String code,
			String area, String type, String order, Date creatTime,
			String head, String address, String mobile) {
		this.deptId = deptId;
		this.name = name;
		this.deptPid = deptPid;
		this.code = code;
		this.area = area;
		this.type = type;
		this.order = order;
		this.creatTime = creatTime;
		this.head = head;
		this.address = address;
		this.mobile = mobile;
	}

	public Dept() {
	}
}