package com.peony.peonydata.baseclass.service;

import java.util.List;

import com.peony.peonydata.area.model.Area;
import com.peony.peonydata.baseclass.model.BaseClass;

/**
 * 基础服务接口
 * 
 * @author jhj
 * @date 
 */
public interface BaseClassService {
	/**
	 * 根据主键删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	int insert(BaseClass record);

	/**
	 * 插入选择数据
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(BaseClass record);

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	BaseClass selectByPrimaryKey(Integer id);

	/**
	 * 根据主键选择更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(BaseClass record);

	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(BaseClass record);

	/**
	 * 查找下级
	 * 
	 * @param parentCode
	 * @return
	 */
	List<BaseClass> findChildren(String parentCode);

	/**
	 * 是否有关键字
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
	boolean loadHasChildren(String Code);

	/**
	 * 查询所有
	 * @return
	 */
	List<BaseClass> selectBaseClass(Integer baseclassPid);
	
	List<BaseClass> selectBaseClassByUserId(Integer userId);
}
