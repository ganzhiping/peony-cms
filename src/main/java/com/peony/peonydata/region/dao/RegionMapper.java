package com.peony.peonydata.region.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.peony.peonydata.dept.model.Dept;
import com.peony.peonydata.menu.model.Menu;
import com.peony.peonydata.region.model.Region;

/**
 * 地域服务接口
 * @author jhj
 */
public interface RegionMapper {
    int deleteByPrimaryKey(Integer regionid);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Integer regionid);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);
    
    List <Region> selectRegions(Region region);
    
	/**
	 * 根据userId加载regions
	 * @param roleId
	 * @return
	 */
	List<Region>selectByUserId(Integer userId);
	
	
	
	/**
	 * 根据code获取region list
	 * @param code
	 * @return
	 */
	List<Region>selectByRegionCode(Region record);
    
	/**
	 * 是否有子节点
	 * 
	 * @param parentCode
	 * @return
	 */
	int loadHasChildren(@Param(value = "parentid")  String parentid);
    
	/**
	 * 查询下级
	 * 
	 * @param parentCode
	 * @return
	 */
	List<Region> selectChildren(@Param(value = "parentid")  String parentid);

}