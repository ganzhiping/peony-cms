package com.peony.peonydata.baseclass.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peony.peonydata.baseclass.model.BaseClass;

public interface BaseClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseClass record);

    int insertSelective(BaseClass record);

    BaseClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseClass record);

    int updateByPrimaryKey(BaseClass record);
    
	/**
	 * 查询下级
	 * 
	 * @param parentCode
	 * @return
	 */
	List<BaseClass> selectChildren(@Param(value = "parentCode") String parentCode);

	/**
	 * 查找用户
	 * 
	 * @param code
	 * @return
	 */
	int findKeyWordNum(String code);

	/**
	 * 是否有关键字
	 * 
	 * @param parentCode
	 * @return
	 */
	int loadHasChildren(@Param(value = "parentCode") String parentCode);

	/**
	 * 查询全部
	 * @return
	 */
	List<BaseClass> selectBaseClass(@Param(value = "baseclassPid") Integer baseclassPid);
	
	
	List<BaseClass> selectBaseClassByUserId(Integer userId);
}