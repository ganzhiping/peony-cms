package com.peony.peonydata.baseclasskeyws.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.baseclasskeyws.dao.BaseClassKeywsMapper;
import com.peony.peonydata.baseclasskeyws.model.BaseClassKeyws;

/**
 * 基础类型关键字接口实现
 *
 * @author jhj
 *
 */
@Service
public class BaseClassKeywsServiceImpl implements BaseClassKeywsService {

    @Resource
    private BaseClassKeywsMapper baseClassKeywsMapper;

    @Override
    public List<BaseClassKeyws> selectBaseClassKeywsByBaseClassId(Integer id) {
        return this.baseClassKeywsMapper.selectBaseClassKeywsByBaseClassId(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return this.baseClassKeywsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BaseClassKeyws baseClassKeyws) {
        return this.baseClassKeywsMapper.insert(baseClassKeyws);
    }

    @Override
    public int insertSelective(BaseClassKeyws record) {
        return this.baseClassKeywsMapper.insertSelective(record);
    }

    @Override
    public BaseClassKeyws selectByPrimaryKey(Integer Id) {
        return this.baseClassKeywsMapper.selectByPrimaryKey(Id);
    }

    @Override
    public int updateByPrimaryKeySelective(BaseClassKeyws record) {
        return this.baseClassKeywsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BaseClassKeyws record) {
        return this.baseClassKeywsMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<BaseClassKeyws> selectByPage(BaseClassKeyws record) {
        List<BaseClassKeyws> list = this.baseClassKeywsMapper.selectByPage(record);
        return new Pagination<BaseClassKeyws>(list, record.getPageParameter());
    }

}
