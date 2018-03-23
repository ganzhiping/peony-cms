package com.peony.peonydata.rolemenu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.rolemenu.dao.RoleMenuMapper;
import com.peony.peonydata.rolemenu.model.RoleMenu;

/**
 * 角色-菜单管理
 *
 * @date：
 * @author jhj
 * @version 1
 */
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper; // 角色-菜单mapper

    @Override
    public int insert(RoleMenu record) {
        return this.roleMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(RoleMenu record) {
        return this.roleMenuMapper.insertSelective(record);
    }

    @Override
    public int deleteByRoleIdAndMenuId(RoleMenu record) {
        return this.roleMenuMapper.deleteByRoleIdAndMenuId(record);
    }
    /**
     * 通过roleId删除 然后通过menuids 插入
     */
    @Override
    public int updateRoleMenu(RoleMenu record) {

        if(record!=null){
            int roleId=record.getRoleId();
            String menuIds=record.getMenuIds();
            String [] arraymenuIds=menuIds.split(",");
            if(menuIds!=null && !"".equals(menuIds)&& roleId>0){
                //delete roleMenu by roleId
                this.roleMenuMapper.deleteByRoleId(record);
                //save
                for(String menuId:arraymenuIds){
                    RoleMenu roleMenu=new RoleMenu();
                    roleMenu.setRoleId(roleId);
                    roleMenu.setMenuId(menuId);
                    this.roleMenuMapper.insert(roleMenu);
                }

            }else{
                //delete roleMenu by roleId
                RoleMenu roleMenu=new RoleMenu();
                roleMenu.setRoleId(Integer.valueOf(roleId));
                this.roleMenuMapper.deleteByRoleId(roleMenu);

            }


        }

        return 0;

    }

}