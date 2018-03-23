package com.peony.peonydata.area.service;

import java.util.List;

import com.peony.peonydata.area.model.Area;
import com.peony.peonydata.dept.model.Dept;

/**
 * 区域服务接口
 * 
 * @author jhj
 * @date 2014-5-8 下午3:37:36
 */
public interface AreaService {
	/**
	 * 根据主键删除
	 * 
	 * @param areaId
	 * @return
	 */
	int deleteByPrimaryKey(Integer areaId);

	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	int insert(Area record);

	/**
	 * 插入选择数据
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(Area record);

	/**
	 * 根据主键查询
	 * 
	 * @param areaId
	 * @return
	 */
	Area selectByPrimaryKey(Integer areaId);

	/**
	 * 根据主键选择更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Area record);

	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Area record);

	/**
	 * 查找下级
	 * 
	 * @param parentCode
	 * @return
	 */
	List<Area> findChildren(String parentCode);

	/**
	 * 是否有用户
	 * 
	 * @param areaCode
	 * @return
	 */
	boolean loadHasKeyWords(String Code);

	/**
	 * 是否有下级
	 * 
	 * @param areaCode
	 * @return
	 */
	boolean loadHasChildren(String areaCode);

	/**
	 * 查询所有部门
	 * @return
	 */
	List<Area> selectAreas();
}
