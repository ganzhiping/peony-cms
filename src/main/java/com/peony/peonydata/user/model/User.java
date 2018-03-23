package com.peony.peonydata.user.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

public class User extends BasePojo {

	private static final long serialVersionUID = 1L;

	private Integer userId;

	private Integer agentId;

	private String useAgentLogo;// 1使用代理商logo 0不使用

	private String loginName;// 登录名

	private String password;

	private String deptId;

	private String name;// 系统显示名称

	private String realName;// 真实姓名

	private String contactName;// 联系人姓名

	private String email;

	private String mobile;

	private String sex;

	private String company;

	private String address;

	private String note;

	private Date createTime;

	private String createUser;

	private Integer createUserId;

	private Date lastLoginTime;

	private String userType;// 1。企业 2。政府

	private String platformType;// 1.正式 2.试用 3.演示

	private Date expiryTime;

	private String startTime;// 查询开始时间
	private String endTime;// 查询结束时间

	private String userStatus;
	private String orderFields;
	private String order;

	private String roleId;// 查询分页使用

	private String personType;// 区分市场用户 和客户
	private String isDelete;// 查询分页使用

	private String userSource;// 0：标识直销 1：标识代理商'

	private Integer belongId;// 所管辖客户的市场人员id

	private String agentName;// 代理商名字

	private String userIds;// 所属的销售人员id

	private String beginCreateTime;// 查询创建时间
	private String endCreateTime;// 查询创建时间

	private String beginExpiryTime;// 查询过期时间
	private String endExpiryTime;// 查询过期时间

	private String type;// 注册类型

	private String systemType;// 0系统用户,1免费手机端用户

	private Float points;// 用户积分
	// *********************消费表
	private Integer comboId;

	private Integer number;

	private Float totalPrice;

	private Date time;

	private String buyWay;

	private String BuyBehavior;
	// ********************
	private String userStyle;// 用户样式

	public String getUserStyle() {
		return userStyle;
	}

	public void setUserStyle(String userStyle) {
		this.userStyle = userStyle;
	}

	public Float getPoints() {
		return points;
	}

	public Integer getComboId() {
		return comboId;
	}

	public void setComboId(Integer comboId) {
		this.comboId = comboId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getBuyWay() {
		return buyWay;
	}

	public void setBuyWay(String buyWay) {
		this.buyWay = buyWay;
	}

	public String getBuyBehavior() {
		return BuyBehavior;
	}

	public void setBuyBehavior(String buyBehavior) {
		BuyBehavior = buyBehavior;
	}

	public void setPoints(Float points) {
		this.points = points;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getBeginExpiryTime() {
		return beginExpiryTime;
	}

	public void setBeginExpiryTime(String beginExpiryTime) {
		this.beginExpiryTime = beginExpiryTime;
	}

	public String getEndExpiryTime() {
		return endExpiryTime;
	}

	public void setEndExpiryTime(String endExpiryTime) {
		this.endExpiryTime = endExpiryTime;
	}

	public String getBeginCreateTime() {
		return beginCreateTime;
	}

	public void setBeginCreateTime(String beginCreateTime) {
		this.beginCreateTime = beginCreateTime;
	}

	public String getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUseAgentLogo() {
		return useAgentLogo;
	}

	public void setUseAgentLogo(String useAgentLogo) {
		this.useAgentLogo = useAgentLogo;
	}

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getUserSource() {
		return userSource;
	}

	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}

	public Integer getBelongId() {
		return belongId;
	}

	public void setBelongId(Integer belongId) {
		this.belongId = belongId;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User(Integer userId, Integer agentId, String loginName,
			String password, String deptId, String name, String email,
			String mobile, String sex, String company, String address,
			String note, Date createTime, String createUser,
			Date lastLoginTime, String userType, String userStatus,
			String orderFields, String order, String personType,
			String isDelete, String userSource, Integer belongId) {
		this.userId = userId;
		this.agentId = agentId;
		this.loginName = loginName;
		this.password = password;
		this.deptId = deptId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.sex = sex;
		this.company = company;
		this.address = address;
		this.note = note;
		this.createTime = createTime;
		this.createUser = createUser;
		this.lastLoginTime = lastLoginTime;
		this.userType = userType;
		this.userStatus = userStatus;
		this.orderFields = orderFields;
		this.order = order;
		this.personType = personType;
		this.isDelete = isDelete;
		this.userSource = userSource;
		this.belongId = belongId;
	}

	public User() {
	}
}