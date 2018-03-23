package com.peony.peonydata.systemlog.model;

import java.util.Date;

import com.peony.core.base.pojo.BasePojo;

public class SystemLog extends BasePojo{
    private Integer id;

	private String content;

	private Date time;

	private String module;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}


	
}