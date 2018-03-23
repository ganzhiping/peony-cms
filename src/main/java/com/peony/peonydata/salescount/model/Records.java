package com.peony.peonydata.salescount.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

public class Records extends BasePojo{
    private Integer id;

    private Integer comboid;

    private Integer number;

    private Float totalprice;

    private Date time;

    private Integer userid;

    private String buyway;

    private String buybehavior;
    
    private Integer count;//套餐交易比数（合计）
    
    private Float price;//套餐交易金额（合计）
    
    private Integer bank;//套餐交易比数（银行付款）
    
    private Float bankPrice;//套餐交易金额（银行付款合计）
    
    private Integer score;//套餐交易比数（积分兑换）
    
    private Float scorePrice;//套餐交易金额（积分兑换）
    
    private String userSource;//0：标识直销    1：标识代理商'
    
    private Integer agentId;//代理商id
    
    private String beginTime;//查询开始时间
    
	private String endTime;//查询结束时间
    
	private String loginName;//登录名
	
	private String platformType;// 1.正式  2.试用 3.演示
	
	private Date expiryTime;//截止日期
	
	
	
    public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getBank() {
		return bank;
	}

	public void setBank(Integer bank) {
		this.bank = bank;
	}

	public Float getBankPrice() {
		return bankPrice;
	}

	public void setBankPrice(Float bankPrice) {
		this.bankPrice = bankPrice;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Float getScorePrice() {
		return scorePrice;
	}

	public void setScorePrice(Float scorePrice) {
		this.scorePrice = scorePrice;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComboid() {
        return comboid;
    }

    public void setComboid(Integer comboid) {
        this.comboid = comboid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Float totalprice) {
        this.totalprice = totalprice;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getBuyway() {
        return buyway;
    }

    public void setBuyway(String buyway) {
        this.buyway = buyway;
    }

    public String getBuybehavior() {
        return buybehavior;
    }

    public void setBuybehavior(String buybehavior) {
        this.buybehavior = buybehavior;
    }
}