package com.peony.peonydata.popular.service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.popular.model.Popular;

/**
 * Created by Administrator on 2018/1/4.
 */
public interface PopularService {
    Pagination<Popular> selectByPage(Popular popular);

    void insert(Popular pubInfo);

    void deleteByPrimaryKey(int id);

    Popular selectByPrimaryKey(int popularId);

    void updateByPrimaryKey(Popular popular);
}
