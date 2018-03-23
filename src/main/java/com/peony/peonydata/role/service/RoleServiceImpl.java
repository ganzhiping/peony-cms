package com.peony.peonydata.role.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.role.dao.RoleMapper;
import com.peony.peonydata.role.model.Role;

/**
 * 角色管理
 *
 * @date：2013-12-24 下午02:55:14
 * @author zhaoshutao@dongao.com
 * @version 1
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper; // 角色mapper

    /**
     * p 根据id加载单个用户
     *
     * @param id
     * @return
     */
    @Override
    public Role selectByPrimaryKey(Integer id) {
        Role role = this.roleMapper.selectByPrimaryKey(id);

        return role;
    }

    /**
     * 编辑用户信息
     *
     * @param id
     * @return
     */
    @Override
    public void editRole(Role role) {

        this.roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public List<Role> selectRoles() {
        return this.roleMapper.selectRoles();
    }

    @Override
    public int deleteByPrimaryKey(Integer roleId) {
        return this.roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insert(Role record) {
        return this.roleMapper.insert(record);
    }

    @Override
    public int insertSelective(Role record) {
        return this.roleMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Role record) {
        return this.roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return this.roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public Pagination<Role> selectByPage(Role record) {
        List<Role> list = this.roleMapper.selectByPage(record);

        return new Pagination<Role>(list, record.getPageParameter());

    }

    @Override
    public List<Role> selectByUserId(Integer userId) {
        List<Role> list=this.roleMapper.selectByUserId(userId);
        return list;
    }

}