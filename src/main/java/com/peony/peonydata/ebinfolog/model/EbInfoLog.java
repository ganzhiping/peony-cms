package com.peony.peonydata.ebinfolog.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

public class EbInfoLog extends BasePojo {
	
	private static final long serialVersionUID = 9065430875157127978L;

	private Integer infoLogId;
	
	private Date publishDate;
	
	private Integer clicks;

    private Integer forwards;

    private Integer collects;

    private String module;

    private String type;

    private String website;

    private String title;

    private String url;
    
    private String sortCondition;//字段不在数据库中，用于排序条件的选择。
    
    private String beginTime;//字段不在数据库中，用于按时间搜索。
    
    private String endTime;//字段不在数据库中，用于按时间搜索。
    
    private Integer counts;//字段不在数据库中 只用于统计。
    
    private Integer clicksCounts;//字段不在数据库中，只用于新闻点击量的统计。
    
    private Integer forwardCounts;//字段不在数据库中，只用于新闻转发量的统计。
    
    private Integer collectsCounts;//字段不在数据库中，只用于新闻收藏量的统计。
      
    public Integer getForwardCounts() {
		return forwardCounts;
	}

	public void setForwardCounts(Integer forwardCounts) {
		this.forwardCounts = forwardCounts;
	}

	public Integer getCollectsCounts() {
		return collectsCounts;
	}

	public void setCollectsCounts(Integer collectsCounts) {
		this.collectsCounts = collectsCounts;
	}

	public Integer getClicksCounts() {
		return clicksCounts;
	}

	public void setClicksCounts(Integer clicksCounts) {
		this.clicksCounts = clicksCounts;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSortCondition() {
		return sortCondition;
	}

	public void setSortCondition(String sortCondition) {
		this.sortCondition = sortCondition;
	}

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

    
    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Integer getForwards() {
        return forwards;
    }

    public void setForwards(Integer forwards) {
        this.forwards = forwards;
    }

    public Integer getCollects() {
        return collects;
    }

    public void setCollects(Integer collects) {
        this.collects = collects;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}