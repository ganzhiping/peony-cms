package com.peony.peonydata.ebinfodetaillog.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

public class EbInfoDetailLog extends BasePojo {
   
	private static final long serialVersionUID = -7597580641101176289L;

    private Integer infodetailLogId;
	
	private Integer infoLogId;

    private Integer userId;
    
    private Date time;

    private String operationType;

	private String loginName;//登录名
	
	private String userType;//1、企业 2、政府
	
	private String userSource;//0：标识直销    1：标识代理商'
	
	private Integer agentId;
	
	private String platformType;// 1.正式  2.试用 3.演示
	
	private String name;//代理商名字

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getInfoLogId() {
        return infoLogId;
    }

    public void setInfoLogId(Integer infoLogId) {
        this.infoLogId = infoLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    
	public Integer getInfodetailLogId() {
		return infodetailLogId;
	}

	public void setInfodetailLogId(Integer infodetailLogId) {
		this.infodetailLogId = infodetailLogId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserSource() {
		return userSource;
	}

	public void setUserSource(String userSource) {
		this.userSource = userSource;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

}