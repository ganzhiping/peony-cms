package com.peony.peonydata.points.model;

import com.peony.core.base.pojo.BasePojo;

public class Points extends BasePojo{
    private Integer id;

    private String type;

    private Float points;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }
}