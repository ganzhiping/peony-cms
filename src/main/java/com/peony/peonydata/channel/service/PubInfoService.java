package com.peony.peonydata.channel.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.baseclasskeyws.model.BaseClassKeyws;
import com.peony.peonydata.channel.model.PubInfo;
import com.peony.peonydata.feedback.model.Feedback;

public interface PubInfoService {
	 	int deleteByPrimaryKey(Integer pubinfoId);

	    int insert(PubInfo record);

	    int insertSelective(PubInfo record);

	    PubInfo selectByPrimaryKey(Integer pubinfoId);

	    int updateByPrimaryKeySelective(PubInfo record);

	    int updateByPrimaryKey(PubInfo record);
	    
	    /**
		 * 查询列表 分页
		 * 
		 * @param record
		 * @return
		 */
	    Pagination<PubInfo> selectByPage(PubInfo record);
	    
	    /**
	     * 只更新pubInfo 不更新pubInfocnt
	     * @param record
	     * @return
	     */
	    int updateBySelective(PubInfo record);
}
