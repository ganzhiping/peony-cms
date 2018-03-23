package com.peony.peonydata.channel.model;

public class Channel {
    private Integer channelId;

    private Integer channelPid;

    private String name;

    private String orderno;

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getChannelPid() {
        return channelPid;
    }

    public void setChannelPid(Integer channelPid) {
        this.channelPid = channelPid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }
}