package com.peony.peonydata.information.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.information.dao.InformationMapper;
import com.peony.peonydata.information.model.Information;

/**
 * 站内消息
 *
 * @author jhj
 * @version 1
 */
@Service
public class InformationServiceImpl implements InformationService {

    @Resource
    private InformationMapper informationMapper;

    @Override
    public int deleteByPrimaryKey(Integer informationId) {
        return this.informationMapper.deleteByPrimaryKey(informationId);
    }

    @Override
    public int insert(Information information) {
        return this.informationMapper.insert(information);
    }

    @Override
    public int insertSelective(Information record) {
        return this.informationMapper.insertSelective(record);
    }

    @Override
    public Information selectByPrimaryKey(Integer informationId) {
        return this.informationMapper.selectByPrimaryKey(informationId);
    }

    @Override
    public int updateByPrimaryKeySelective(Information record) {
        return this.informationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Information record) {
        return this.informationMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Information> selectInformations() {
        return this.informationMapper.selectInformations();
    }

    @Override
    public Pagination<Information> selectByPage(Information record) {
        List<Information> list = this.informationMapper.selectByPage(record);
        return new Pagination<Information>(list, record.getPageParameter());
    }

}
