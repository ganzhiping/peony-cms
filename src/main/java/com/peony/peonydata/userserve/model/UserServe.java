package com.peony.peonydata.userserve.model;


/**
 * 服务设置
 * @author jhj
 *
 */
public class UserServe {
	
    private Integer userserviceId;
    private Integer userId;
    private Integer keywsNumber;
    private Integer warnKeywsNumber;
    private Integer emailNumber;
    private Integer phoneNumber;
    private String  reportTime;
    private Integer mobileNumber;
    private String  warnReTime;
    private String  deadline=null;
    private String  status;//1.有效 2.无效
    private String  platformType;// 1.正式  2.试用 3.演示
    
    private String warningSend;//是否发送预警 0否 1是
    
    private String reportCreate;//是否生成日报 0否 1是
    
    private String reportSend;//是否发送日报 0否 1是

    public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	public Integer getUserserviceId() {
        return userserviceId;
    }

    public void setUserserviceId(Integer userserviceId) {
        this.userserviceId = userserviceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getKeywsNumber() {
        return keywsNumber;
    }

    public void setKeywsNumber(Integer keywsNumber) {
        this.keywsNumber = keywsNumber;
    }

    public Integer getWarnKeywsNumber() {
        return warnKeywsNumber;
    }

    public void setWarnKeywsNumber(Integer warnKeywsNumber) {
        this.warnKeywsNumber = warnKeywsNumber;
    }

    public Integer getEmailNumber() {
        return emailNumber;
    }

    public void setEmailNumber(Integer emailNumber) {
        this.emailNumber = emailNumber;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getWarnReTime() {
        return warnReTime;
    }

    public void setWarnReTime(String warnReTime) {
        this.warnReTime = warnReTime;
    }



	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getWarningSend() {
		return warningSend;
	}

	public void setWarningSend(String warningSend) {
		this.warningSend = warningSend;
	}

	public String getReportCreate() {
		return reportCreate;
	}

	public void setReportCreate(String reportCreate) {
		this.reportCreate = reportCreate;
	}

	public String getReportSend() {
		return reportSend;
	}

	public void setReportSend(String reportSend) {
		this.reportSend = reportSend;
	}



}