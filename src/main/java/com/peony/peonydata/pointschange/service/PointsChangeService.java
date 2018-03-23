package com.peony.peonydata.pointschange.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.pointschange.model.PointsChange;

public interface PointsChangeService {
	/**
	 * 查询积分明细分页
	 * @param pointschange
	 * @return
	 */
	Pagination<PointsChange> selectPointsChangesByPage(PointsChange pointschange);
}
