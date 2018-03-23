package com.peony.peonydata.combo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.combo.dao.ComboMapper;
import com.peony.peonydata.combo.model.Combo;

@Service
public class ComboServiceImpl implements ComboService {
    @Resource
    private ComboMapper comboMapper;

    @Override
    public List<Combo> selectComboList() {
        List<Combo> cList = this.comboMapper.selectComboList();
        return cList;
    }

    @Override
    public Pagination<Combo> selectByPage(Combo combo) {
        List<Combo> list = this.comboMapper.selectByPage(combo);
        return new Pagination<Combo>(list, combo.getPageParameter());
    }

    @Override
    public int insertSelective(Combo combo) {
        return this.comboMapper.insertSelective(combo);
    }

    @Override
    public int updateByPrimaryKeySelective(Combo record) {
        return this.comboMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Combo selectByPrimaryKey(Integer id) {
        return this.comboMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Combo> selectAllCombos() {
        return this.comboMapper.selectAllCombos();
    }

}
