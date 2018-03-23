package com.peony.peonydata.areakeyws.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

public class AreaKeyws extends BasePojo{
    private Integer areaKeywsId;

    private String name;

    private Date createTime;

    private Integer areaId;

    public Integer getAreaKeywsId() {
        return areaKeywsId;
    }

    public void setAreaKeywsId(Integer areaKeywsId) {
        this.areaKeywsId = areaKeywsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}