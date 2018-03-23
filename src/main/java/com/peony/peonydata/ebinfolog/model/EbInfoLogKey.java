package com.peony.peonydata.ebinfolog.model;

import java.util.Date;

public class EbInfoLogKey {
	
    private Integer infoLogId;

    private Date publishDate;

    public Integer getInfoLogId() {
        return infoLogId;
    }

    public void setInfoLogId(Integer infoLogId) {
        this.infoLogId = infoLogId;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}