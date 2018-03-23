package com.peony.peonydata.baseclass.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.baseclass.dao.BaseClassMapper;
import com.peony.peonydata.baseclass.model.BaseClass;

/**
 * 区域服务
 *
 * @author jhj
 * @date
 */

@Service
public class BaseClassServiceImpl implements BaseClassService {
    @Resource
    private BaseClassMapper baseClassMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseClassMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BaseClass record) {
        return this.baseClassMapper.insert(record);
    }

    @Override
    public int insertSelective(BaseClass record) {
        return this.baseClassMapper.insertSelective(record);
    }

    @Override
    public BaseClass selectByPrimaryKey(Integer id) {
        return this.baseClassMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseClass record) {
        return this.baseClassMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseClass record) {
        return this.baseClassMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<BaseClass> findChildren(String parentCode) {
        return this.baseClassMapper.selectChildren(parentCode);
    }

    @Override
    public boolean loadHasChildren(String Code) {
        return this.baseClassMapper.loadHasChildren(Code) == 1;
    }

    @Override
    public boolean loadHasKeyWords(String Code) {
        return this.baseClassMapper.findKeyWordNum(Code) > 0;
    }

    @Override
    public List<BaseClass> selectBaseClass(Integer baseclassPid) {
        return this.baseClassMapper.selectBaseClass(baseclassPid);
    }

    @Override
    public List<BaseClass> selectBaseClassByUserId(Integer userId) {
        return this.baseClassMapper.selectBaseClassByUserId(userId);
    }

}
