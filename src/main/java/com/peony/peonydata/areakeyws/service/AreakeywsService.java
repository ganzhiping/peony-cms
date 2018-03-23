package com.peony.peonydata.areakeyws.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.areakeyws.model.AreaKeyws;

/**
 * 区域关键字接口
 * @author jhj
 *
 */
public interface AreakeywsService {

	
	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<AreaKeyws> selectByPage(AreaKeyws record);
	/**
	 * 按地域id 获取列表 分页
	 * @return
	 */
	List<AreaKeyws> selectAreaKeywsByAreaId(Integer areaId);
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
	 * @param 
	 * @return
	 */
	int insert(AreaKeyws areaKeyws);

	/**
	 * 插入选择数据
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(AreaKeyws record);

	/**
	 * 根据主键查询
	 * 
	 * @param Id
	 * @return
	 */
	AreaKeyws selectByPrimaryKey(Integer Id);

	/**
	 * 根据主键选择更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(AreaKeyws record);

	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(AreaKeyws record);
}
