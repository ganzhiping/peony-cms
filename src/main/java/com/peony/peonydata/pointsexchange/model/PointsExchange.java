package com.peony.peonydata.pointsexchange.model;

import com.peony.core.base.pojo.BasePojo;

public class PointsExchange extends BasePojo{
    private Integer id;

    private Float points;

    private Float unitprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }

    public Float getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Float unitprice) {
        this.unitprice = unitprice;
    }
}