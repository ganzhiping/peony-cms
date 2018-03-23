package com.peony.peonydata.menu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.menu.dao.MenuMapper;
import com.peony.peonydata.menu.model.Menu;

/**
 * 菜单服务
 *
 * @author lenovo41
 * @date 2014-5-8 下午3:38:07
 */

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public int deleteByPrimaryKey(Integer menuId) {

        return this.menuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insert(Menu record) {

        return this.menuMapper.insert(record);
    }

    @Override
    public int insertSelective(Menu record) {

        return this.menuMapper.insertSelective(record);
    }

    @Override
    public Menu selectByPrimaryKey(Integer menuId) {

        return this.menuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByPrimaryKeySelective(Menu record) {

        return this.menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Menu record) {

        return this.menuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Menu> selectMenus() {

        return this.menuMapper.selectMenus();
    }

    @Override
    public List<Menu> selectByRoleId(Integer roleId) {
        return this.menuMapper.selectByRoleId(roleId);
    }

    @Override
    public List<Menu> selectByMenuCode(Menu record) {
        return this.menuMapper.selectByMenuCode(record);
    }

    @Override
    public List<Menu> selectAllMenus() {
        return this.menuMapper.selectAllMenus();
    }
}
