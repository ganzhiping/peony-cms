package com.peony.peonydata.areakeyws.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.areakeyws.dao.AreaKeywsMapper;
import com.peony.peonydata.areakeyws.model.AreaKeyws;

/**
 * 区域关键字接口实现
 *
 * @author jhj
 *
 */
@Service
public class AreakeywsServiceImpl implements AreakeywsService {

    @Resource
    private AreaKeywsMapper areaKeywsMapper;

    @Override
    public List<AreaKeyws> selectAreaKeywsByAreaId(Integer id) {
        return this.areaKeywsMapper.selectAreakeywsByAreaId(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.areaKeywsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AreaKeyws areaKeyws) {

        return this.areaKeywsMapper.insert(areaKeyws);
    }

    @Override
    public int insertSelective(AreaKeyws record) {
        return this.areaKeywsMapper.insertSelective(record);
    }

    @Override
    public AreaKeyws selectByPrimaryKey(Integer Id) {
        return this.areaKeywsMapper.selectByPrimaryKey(Id);
    }

    @Override
    public int updateByPrimaryKeySelective(AreaKeyws record) {
        return this.areaKeywsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AreaKeyws record) {
        return this.areaKeywsMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<AreaKeyws> selectByPage(AreaKeyws record) {
        List<AreaKeyws> list = this.areaKeywsMapper.selectByPage(record);
        return new Pagination<AreaKeyws>(list, record.getPageParameter());
    }

}
