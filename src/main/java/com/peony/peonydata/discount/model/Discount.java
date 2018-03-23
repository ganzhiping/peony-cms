package com.peony.peonydata.discount.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

public class Discount extends BasePojo{
    private Integer id;

    private Integer comboid;

    private Integer beginday;

    private Integer endday;

    private Float discount;

    private Date time;

    private String name;//套餐名称
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

    public Integer getBeginday() {
        return beginday;
    }

    public void setBeginday(Integer beginday) {
        this.beginday = beginday;
    }

    public Integer getEndday() {
        return endday;
    }

    public void setEndday(Integer endday) {
        this.endday = endday;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}