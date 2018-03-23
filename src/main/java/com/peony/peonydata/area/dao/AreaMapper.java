package com.peony.peonydata.area.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peony.peonydata.area.model.Area;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    
	/**
	 * 查询下级
	 * 
	 * @param parentCode
	 * @return
	 */
	List<Area> selectChildren(@Param(value = "parentCode") String parentCode);

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
	List<Area> selectAreas();
}