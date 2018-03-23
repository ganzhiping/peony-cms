package com.peony.peonydata.operationlog.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

public class OperationLog extends BasePojo {
	private static final long serialVersionUID = 3242837699851358331L;

	private String operationLogId;

    private Date time;

    private Integer userId;

    private String name;

    private String type;

    private String loginType;

    private String content1;
    
    private String content;
    
    private Integer counts;//字段不在数据库中 只用于统计
    
    private String operateType;
    
    private String operateModule;
    
    private String title;//用于统计结果显示，字段不在数据库中
    

    public String getOperationLogId() {
		return operationLogId;
	}

	public void setOperationLogId(String operationLogId) {
		this.operationLogId = operationLogId;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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



	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
}