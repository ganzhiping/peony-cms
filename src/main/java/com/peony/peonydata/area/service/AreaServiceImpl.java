package com.peony.peonydata.area.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.area.dao.AreaMapper;
import com.peony.peonydata.area.model.Area;

/**
 * 区域服务
 *
 * @author jhj
 * @date
 */

@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaMapper areaMapper;

    @Override
    public int deleteByPrimaryKey(Integer areaId) {
        return this.areaMapper.deleteByPrimaryKey(areaId);
    }

    @Override
    public int insert(Area record) {
        return this.areaMapper.insert(record);
    }

    @Override
    public int insertSelective(Area record) {
        return this.areaMapper.insertSelective(record);
    }

    @Override
    public Area selectByPrimaryKey(Integer areaId) {
        return this.areaMapper.selectByPrimaryKey(areaId);
    }

    @Override
    public int updateByPrimaryKeySelective(Area record) {

        return this.areaMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Area record) {

        return this.areaMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据父部门编码，查找子部门
     */
    @Override
    public List<Area> findChildren(String parentCode) {
        return this.areaMapper.selectChildren(parentCode);
    }

    @Override
    public boolean loadHasChildren(String departmentCode) {
        return this.areaMapper.loadHasChildren(departmentCode) == 1;
    }

    @Override
    public List<Area> selectAreas() {
        return this.areaMapper.selectAreas();
    }

    @Override
    public boolean loadHasKeyWords(String Code) {
        return this.areaMapper.findKeyWordNum(Code) > 0;
    }
}
