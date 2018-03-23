package com.peony.peonydata.popular.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.popular.dao.PopularMapper;
import com.peony.peonydata.popular.model.Popular;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 */
@Service
public class PopularServiceImpl implements PopularService {
    @Resource
    private PopularMapper popularMapper;
    @Override
    public Pagination<Popular> selectByPage(Popular popular) {
        List<Popular> list = popularMapper.selectByPage(popular);
        return new Pagination<Popular>(list, popular.getPageParameter());
    }

    @Override
    public void insert(Popular pubInfo) {
        popularMapper.insert(pubInfo);
    }

    @Override
    public void deleteByPrimaryKey(int id) {
        Popular popular = new Popular();
        popular.setPopularId(id);
        popularMapper.delete(popular);
    }

    @Override
    public Popular selectByPrimaryKey(int popularId) {
        return popularMapper.selectByPrimaryKey(popularId);
    }

    @Override
    public void updateByPrimaryKey(Popular popular) {
        popularMapper.update(popular);
    }
}
