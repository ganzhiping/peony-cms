package com.peony.peonydata.popular.dao;

import com.peony.peonydata.popular.model.Popular;

import java.util.List;

/**
 * Created by Administrator on 2018/1/4.
 */
public interface PopularMapper {
    List<Popular> selectByPage(Popular popular);

    void insert(Popular pubInfo);

    void delete(Popular popular);

    Popular selectByPrimaryKey(int popularId);

    void update(Popular popular);
}
