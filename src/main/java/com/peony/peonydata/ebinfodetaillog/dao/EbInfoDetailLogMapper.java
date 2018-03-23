package com.peony.peonydata.ebinfodetaillog.dao;

import java.util.List;

import com.peony.peonydata.ebinfodetaillog.model.EbInfoDetailLog;
import com.peony.peonydata.ebinfodetaillog.model.EbInfoDetailLogKey;

public interface EbInfoDetailLogMapper {
	
    int deleteByPrimaryKey(EbInfoDetailLogKey key);

    int insert(EbInfoDetailLog record);

    int insertSelective(EbInfoDetailLog record);

    EbInfoDetailLog selectByPrimaryKey(EbInfoDetailLogKey key);

    int updateByPrimaryKeySelective(EbInfoDetailLog record);

    int updateByPrimaryKey(EbInfoDetailLog record);
    
    /**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	List<EbInfoDetailLog> selectByPage(EbInfoDetailLog record);
}