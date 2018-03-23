package com.peony.peonydata.dept.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peony.peonydata.dept.model.Dept;

/**
 * 部门dao接口
 * 
 * @author lenovo41
 * @date 2014-5-8 下午3:31:56
 */
/**
 *
 * @author lenovo41
 * @date  2014-5-9 下午3:04:08
 */
public interface DeptMapper {
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
	 * 查询下级
	 * 
	 * @param parentCode
	 * @return
	 */
	List<Dept> selectChildren(@Param(value = "parentCode") String parentCode);

	/**
	 * 查找用户
	 * 
	 * @param code
	 * @return
	 */
	int findUserNum(String code);

	/**
	 * 是否有用户
	 * 
	 * @param parentCode
	 * @return
	 */
	int loadHasChildren(@Param(value = "parentCode") String parentCode);

	/**
	 * 查询全部
	 * @return
	 */
	List<Dept> selectDepts();
}