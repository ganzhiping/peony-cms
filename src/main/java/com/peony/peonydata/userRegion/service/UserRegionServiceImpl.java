package com.peony.peonydata.userRegion.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.userRegion.dao.UserRegionMapper;
import com.peony.peonydata.userRegion.model.UserRegion;

/**
 * 用户-地域服务
 *
 * @author jhj
 */
@Service
public class UserRegionServiceImpl implements UserRegionService {

    @Resource
    private UserRegionMapper userRegionMapper; // 用户-地域mapper

    @Override
    public int insert(UserRegion record) {
        return this.userRegionMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRegion record) {
        return this.userRegionMapper.insertSelective(record);
    }

    @Override
    public int deleteByUserId(int userId) {
        return this.userRegionMapper.deleteByUserId(userId);
    }

    @Override
    public int deleteByUserIdAndRegionId(UserRegion record) {
        return this.userRegionMapper.deleteByUserIdAndRegionId(record);
    }

    @Override
    public List<UserRegion> findUserByRegionId(int regionId) {

        return this.userRegionMapper.findUserByRegionId(regionId);
    }

    @Override
    public List<UserRegion> findByUserId(int userId) {
        return this.userRegionMapper.findByUserId(userId);
    }

}
