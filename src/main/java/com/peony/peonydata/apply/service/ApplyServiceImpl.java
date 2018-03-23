package com.peony.peonydata.apply.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.apply.dao.ApplyMapper;
import com.peony.peonydata.apply.model.Apply;

/**
 * 站内消息
 *
 * @author jhj
 * @version 1
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Resource
    private ApplyMapper applyMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.applyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Apply record) {
        return this.applyMapper.insert(record);
    }

    @Override
    public Apply selectByPrimaryKey(Integer id) {
        return this.applyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Apply record) {
        return this.applyMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<Apply> selectByPage(Apply record) {
        List<Apply> list = this.applyMapper.selectByPage(record);
        return new Pagination<Apply>(list, record.getPageParameter());
    }

    @Override
    public int updateByPrimaryKeySelective(Apply record) {
        return this.applyMapper.updateByPrimaryKeySelective(record);
    }

}
