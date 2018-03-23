package com.peony.peonydata.region.model;

import com.peony.peonydata.menu.model.Menu;

public class Region {
    private Integer regionid;

    private Integer provinceid;

    private String regionname;

    private Integer regionlevel;

    private Integer parentid;

    private String regionabbr;

    private Integer ordinal;

    public Integer getRegionid() {
        return regionid;
    }

    public void setRegionid(Integer regionid) {
        this.regionid = regionid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname;
    }

    public Integer getRegionlevel() {
        return regionlevel;
    }

    public void setRegionlevel(Integer regionlevel) {
        this.regionlevel = regionlevel;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getRegionabbr() {
        return regionabbr;
    }

    public void setRegionabbr(String regionabbr) {
        this.regionabbr = regionabbr;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }
    
  	@Override
  	public int hashCode() {
  		final int prime = 31;
  		int result = 1;
  		result = prime * result + regionid;
  		return result;
  	}

  	@Override
  	public boolean equals(Object obj) {
  		if (this == obj)
  			return true;
  		if (obj == null)
  			return false;
  		if (getClass() != obj.getClass())
  			return false;
  		Region other = (Region) obj;
  		if (regionid != other.regionid)
  			return false;
  		return true;
  	}
}