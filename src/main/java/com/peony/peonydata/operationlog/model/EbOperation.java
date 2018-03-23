package com.peony.peonydata.operationlog.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;


/**
 * e本操作日志
 * 
 */
public class EbOperation extends BasePojo {
	private static final long serialVersionUID = -4076957158717777638L;

	 private String operationLogId;

	 private Date time;
	private Integer userId;//用户id

    private String name;//用户名

    private String type;//操作类型 1为登录 2为操作

    private String loginType;//注册类型 QQ 1 ，微博 2 ，微信 3 ，qq空间4，手机5

    private String content;

    private String operateType;//'操作类型',

    private String operateModule;//'操作模块'

    private String content1;
    
    private String startTime;//查询开始时间
	private String endTime;//查询结束时间

	private String userSource;//销售类型  0：标识直销    1：标识代理商
	
	private String platformType;//1.正式 2.注册 3.未注册 （正式移动免费版开通过付费功能的用户为正式用户，注册但未开通过的用户为试用用户。其余登录用户为演示用户。）
	private String userStatus;//1-有效 3-无效'
	private Integer agentId;//代理商id
	
    public Integer getAgentId() {
		return agentId;
	}

	

	public String getOperationLogId() {
		return operationLogId;
	}



	public void setOperationLogId(String operationLogId) {
		this.operationLogId = operationLogId;
	}



	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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


	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
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

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getOperateModule() {
        return operateModule;
    }

    public void setOperateModule(String operateModule) {
        this.operateModule = operateModule;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }
}