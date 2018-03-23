package com.peony.peonydata.util;

import java.util.Comparator;

import com.peony.peonydata.region.model.Region;

/**
 * Region 比较器 通过id对地域排序
 * @author jhj
 *
 */
public class RegionComparator  implements Comparator<Region> {

	@Override
	public int compare(Region o1, Region o2) {
		return o1.getRegionid().compareTo(o2.getRegionid());
	}

	
	
	
}
