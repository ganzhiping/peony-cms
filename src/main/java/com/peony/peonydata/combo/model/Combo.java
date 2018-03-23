package com.peony.peonydata.combo.model;

import com.peony.core.base.pojo.BasePojo;

public class Combo extends BasePojo{
    private Integer id;

    private String name;

    private Integer keywordnumber;

    private Integer topicnumber;

    private String introduce;

    private Float price;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getKeywordnumber() {
        return keywordnumber;
    }

    public void setKeywordnumber(Integer keywordnumber) {
        this.keywordnumber = keywordnumber;
    }

    public Integer getTopicnumber() {
        return topicnumber;
    }

    public void setTopicnumber(Integer topicnumber) {
        this.topicnumber = topicnumber;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}