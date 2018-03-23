package com.peony.peonydata.channel.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

public class PubInfo extends BasePojo{
    private Integer pubinfoId;

    private String title;

    private String subhead;

    private Date time;

    private String keywords;

    private String type;

    private String image;

    private String summary;

    private String url;

    private String channelId;

    private String state;

    private String isTop;
    
    private String author;
    

    private Integer userId;
    
    
    private String content;
    
    private String subjectRecommend;
    
    private String caseRecommend;
    
    private String bigImage;
    
    private String longImage;
    
    private String smallImage;
    
    private String isSubject;
    
    public String getSubjectRecommend() {
		return subjectRecommend;
	}

	public void setSubjectRecommend(String subjectRecommend) {
		this.subjectRecommend = subjectRecommend;
	}

	public String getCaseRecommend() {
		return caseRecommend;
	}

	public void setCaseRecommend(String caseRecommend) {
		this.caseRecommend = caseRecommend;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPubinfoId() {
        return pubinfoId;
    }

    public void setPubinfoId(Integer pubinfoId) {
        this.pubinfoId = pubinfoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIsTop() {
        return isTop;
    }

    public void setIsTop(String isTop) {
        this.isTop = isTop;
    }

	public String getBigImage() {
		return bigImage;
	}

	public void setBigImage(String bigImage) {
		this.bigImage = bigImage;
	}

	public String getLongImage() {
		return longImage;
	}

	public void setLongImage(String longImage) {
		this.longImage = longImage;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public String getIsSubject() {
		return isSubject;
	}

	public void setIsSubject(String isSubject) {
		this.isSubject = isSubject;
	}
    
}