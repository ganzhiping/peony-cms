package com.peony.peonydata.menu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.peony.peonydata.menu.model.Menu;

public interface MenuMapper {
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
	int insert(Menu record);

	/**
	 * 插入选择数据
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(Menu record);

	/**
	 * 根据主键查询
	 * 
	 * @param deptId
	 * @return
	 */
	Menu selectByPrimaryKey(Integer deptId);

	/**
	 * 根据主键选择更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Menu record);

	/**
	 * 根据主键更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(Menu record);

	/**
	 * 查询可见的菜单列表
	 * 
	 * @return
	 */
	List<Menu> selectMenus();
	
	
	/**
	 * 查询全部菜单列表
	 * 
	 * @return
	 */
	List<Menu> selectAllMenus();
	
	/**
	 * 根据roleId加载menus
	 * @param roleId
	 * @return
	 */
	List<Menu>selectByRoleId(Integer roleId);
	
	
	
	/**
	 * 根据code获取menu list
	 * @param code
	 * @return
	 */
	List<Menu>selectByMenuCode(Menu record);
}