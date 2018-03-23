package com.peony.peonydata.dept.service;

import java.util.List;

import com.peony.peonydata.dept.model.Dept;

/**
 * 部门服务接口
 * 
 * @author lenovo41
 * @date 2014-5-8 下午3:37:36
 */
public interface DeptService {
	/**
	 * 根据主键删除
	 * 
	 * @param deptId
	 * @return
	 */
	int deleteByPrimaryKey(Integer deptId);

	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	int insert(Dept record);

	/**
	 * 插入选择数据
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(Dept record);

	/**
	 * 根据主键查询
	 * 
	 * @param deptId
	 * @return
	 */
	Dept selectByPrimaryKey(Integer deptId);

	/**
	 * 根据主键选择更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Dept record);

	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Dept record);

	/**
	 * 查找下级
	 * 
	 * @param parentCode
	 * @return
	 */
	List<Dept> findChildren(String parentCode);

	/**
	 * 是否有用户
	 * 
	 * @param departmentCode
	 * @return
	 */
	boolean loadHasUser(String departmentCode);

	/**
	 * 是否有下级
	 * 
	 * @param departmentCode
	 * @return
	 */
	boolean loadHasChildren(String departmentCode);

	/**
	 * 查询所有部门
	 * 
	 * @return
	 */
	List<Dept> selectDepts();
}
