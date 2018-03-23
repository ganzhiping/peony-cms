package com.peony.peonydata.region.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.region.dao.RegionMapper;
import com.peony.peonydata.region.model.Region;

/**
 * 地域管理
 * @author jhj
 */
@Service
public class RegionServiceImpl implements RegionService {
    @Resource
    private RegionMapper regionMapper; // 地域mapper

    @Override
    public int deleteByPrimaryKey(Integer regionid) {
        return this.regionMapper.deleteByPrimaryKey(regionid);
    }

    @Override
    public int insert(Region record) {
        return this.regionMapper.insert(record);
    }

    @Override
    public int insertSelective(Region record) {
        return this.regionMapper.insertSelective(record);
    }

    @Override
    public Region selectByPrimaryKey(Integer regionid) {
        return this.regionMapper.selectByPrimaryKey(regionid);
    }

    @Override
    public int updateByPrimaryKeySelective(Region record) {
        return this.regionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Region record) {
        return this.regionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Region> selectRegions(Region region) {
        return this.regionMapper.selectRegions(region);
    }

    @Override
    public List<Region> selectByUserId(Integer userId) {
        return this.regionMapper.selectByUserId(userId);
    }

    @Override
    public List<Region> selectByRegionCode(Region record) {
        return this.regionMapper.selectByRegionCode(record);
    }

    @Override
    public boolean loadHasChildren(String code) {
        return this.regionMapper.loadHasChildren(code) == 1;
    }

    /**
     * 根据父编码，查找子地域
     */
    @Override
    public List<Region> findChildren(String parentCode) {
        return this.regionMapper.selectChildren(parentCode);
    }
}
