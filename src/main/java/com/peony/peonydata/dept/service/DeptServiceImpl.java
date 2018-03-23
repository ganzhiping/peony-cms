package com.peony.peonydata.dept.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.dept.dao.DeptMapper;
import com.peony.peonydata.dept.model.Dept;

/**
 * 部门服务
 *
 * @author lenovo41
 * @date 2014-5-8 下午3:38:07
 */

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    @Override
    public int deleteByPrimaryKey(Integer deptId) {

        return this.deptMapper.deleteByPrimaryKey(deptId);
    }

    @Override
    public int insert(Dept record) {

        return this.deptMapper.insert(record);
    }

    @Override
    public int insertSelective(Dept record) {

        return this.deptMapper.insertSelective(record);
    }

    @Override
    public Dept selectByPrimaryKey(Integer deptId) {

        return this.deptMapper.selectByPrimaryKey(deptId);
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) {

        return this.deptMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dept record) {

        return this.deptMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据父部门编码，查找子部门
     */
    @Override
    public List<Dept> findChildren(String parentCode) {
        return this.deptMapper.selectChildren(parentCode);
    }

    @Override
    public boolean loadHasUser(String departmentCode) {
        return this.deptMapper.findUserNum(departmentCode + "%") > 0;
    }

    @Override
    public boolean loadHasChildren(String departmentCode) {
        return this.deptMapper.loadHasChildren(departmentCode) == 1;
    }

    @Override
    public List<Dept> selectDepts() {

        return this.deptMapper.selectDepts();
    }
}
