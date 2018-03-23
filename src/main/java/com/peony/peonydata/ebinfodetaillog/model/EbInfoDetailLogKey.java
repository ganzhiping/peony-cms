package com.peony.peonydata.ebinfodetaillog.model;

import java.util.Date;

public class EbInfoDetailLogKey {
    private Integer infodetailLogId;

    private Date time;

    public Integer getInfodetailLogId() {
        return infodetailLogId;
    }

    public void setInfodetailLogId(Integer infodetailLogId) {
        this.infodetailLogId = infodetailLogId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}