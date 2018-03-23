package com.peony.peonydata.ebinfodetaillog.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.ebinfodetaillog.model.EbInfoDetailLog;

public interface EbInfoDetailLogService {

	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<EbInfoDetailLog> selectByPage(EbInfoDetailLog record);
 
}
