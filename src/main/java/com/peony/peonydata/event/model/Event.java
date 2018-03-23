package com.peony.peonydata.event.model;

public class Event {
    private Integer eventid;

    private String eventname;

    private Integer parenteventid;

    private Integer status;

    private Integer isPublic;

    public Integer getEventid() {
        return eventid;
    }

    public void setEventid(Integer eventid) {
        this.eventid = eventid;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Integer getParenteventid() {
        return parenteventid;
    }

    public void setParenteventid(Integer parenteventid) {
        this.parenteventid = parenteventid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }
}