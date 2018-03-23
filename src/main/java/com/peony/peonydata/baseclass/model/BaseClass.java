package com.peony.peonydata.baseclass.model;

import com.peony.core.base.pojo.BasePojo;

public class BaseClass extends BasePojo{
    private Integer baseclassId;

    private Integer baseclassPid;

    private String name;

    private String order;

    private String explain;
    
    private Integer isPublic;
    
    public Integer getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}

	public Integer getBaseclassId() {
        return baseclassId;
    }

    public void setBaseclassId(Integer baseclassId) {
        this.baseclassId = baseclassId;
    }

    public Integer getBaseclassPid() {
        return baseclassPid;
    }

    public void setBaseclassPid(Integer baseclassPid) {
        this.baseclassPid = baseclassPid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}