package com.peony.peonydata.baseclasskeyws.service;

import java.util.List;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.baseclasskeyws.model.BaseClassKeyws;

/**
 * 区域关键字接口
 * @author jhj
 *
 */
public interface BaseClassKeywsService {

	
	/**
	 * 查询列表 分页
	 * 
	 * @param record
	 * @return
	 */
	Pagination<BaseClassKeyws> selectByPage(BaseClassKeyws record);
	/**
	 * 按地域id 获取列表 分页
	 * @return
	 */
	List<BaseClassKeyws> selectBaseClassKeywsByBaseClassId(Integer areaId);
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
	int insert(BaseClassKeyws baseClassKeyws);

	/**
	 * 插入选择数据
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(BaseClassKeyws record);

	/**
	 * 根据主键查询
	 * 
	 * @param Id
	 * @return
	 */
	BaseClassKeyws selectByPrimaryKey(Integer Id);

	/**
	 * 根据主键选择更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(BaseClassKeyws record);

	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(BaseClassKeyws record);
}
