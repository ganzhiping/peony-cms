package com.peony.peonydata.pointschange.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

public class PointsChange extends BasePojo{
    private Integer id;

    private Integer userid;

    private Float points;

    private String instructions;

    private String type;

    private Date time;
    
    private String loginName;//登录名
    
    private Integer typestatus;//注册类型 1.qq 2.微博  3.微信 4.qq空间 5.手机
    
    private String userSource;//0：标识直销    1：标识代理商
    
    private Integer agentId;//代理商id
    
    private String platformType;// 1.正式  2.试用 3.演示
    
    private String beginCreateTime;
    
    private String endCreateTime;
    
    
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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getTypestatus() {
		return typestatus;
	}

	public void setTypestatus(Integer typestatus) {
		this.typestatus = typestatus;
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

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}