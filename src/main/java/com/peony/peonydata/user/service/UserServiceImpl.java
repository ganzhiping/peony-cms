package com.peony.peonydata.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.core.base.pojo.Pagination;
import com.peony.peonydata.key.dao.IdMapper;
import com.peony.peonydata.key.model.KeyGen;
import com.peony.peonydata.user.dao.UserMapper;
import com.peony.peonydata.user.model.User;
import com.peony.peonydata.userRole.dao.UserRoleMapper;
import com.peony.peonydata.userserve.dao.UserServeMapper;
import com.peony.peonydata.userserve.model.UserServe;

/**
 * 用户服务接口
 *
 * @date 2013-10-24 下午05:42:49
 * @author zhaoshutao
 * @version 1
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper      userMapper;     // 用户mapper

    @Resource
    private UserRoleMapper  userRoleMapper; // 用户-角色关联mapper

    @Resource
    private UserServeMapper userServeMapper;

    @Resource
    private IdMapper        idMapper;

    /**
     * p 根据id加载单个用户
     *
     * @param id
     * @return
     */
    @Override
    public User selectByPrimaryKey(Integer id) {
        User user = this.userMapper.selectByPrimaryKey(id);

        return user;
    }

    /**
     * 编辑用户信息
     *
     * @param id
     * @return
     */
    @Override
    public void editUser(User user) {

        this.userMapper.updateByPrimaryKey(user);
    }

    @Override
    public List<User> selectUsers(User user) {
        return this.userMapper.selectUsers(user);
    }

    /***
     * 批量假删除
     *
     * @param userIds
     */
    @Override
    public int deleteByPrimaryKey(String userIds) {
        String array[] = userIds.split(",");
        User user = new User();
        for (String id : array) {
            user.setUserId(Integer.valueOf(id));
            user.setIsDelete("1");
            this.userMapper.updateByPrimaryKeySelective(user);
        }

        return 0;
    }

    @Override
    public int insert(User record) {
        UserServe us = new UserServe();
        int key = KeyGen.getInstance().getNextKey("userService_id", this.idMapper);
        us.setUserserviceId(key);
        us.setUserId(record.getUserId());
        this.userServeMapper.insertSelective(us);

        return this.userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        UserServe us = new UserServe();
        int key = KeyGen.getInstance().getNextKey("userService_id", this.idMapper);
        us.setUserserviceId(key);
        us.setUserId(record.getUserId());
        this.userServeMapper.insertSelective(us);
        return this.userMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return this.userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return this.userMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据用户登录名查询 param loginName
     */
    @Override
    public List<User> selectUserByLoginName(String loginName) {
        return this.userMapper.selectUserByLoginName(loginName);
    }

    @Override
    public Pagination<User> selectByPage(User record) {
        List<User> list = this.userMapper.selectByPage(record);
        return new Pagination<User>(list, record.getPageParameter());

    }

    /**
     * create by ganzhiping
     * time:2018年1月5日13:26:02
     * @param record
     * @return
     */
    @Override
    public List<User> selectByPopular(User record) {
        List<User> list = this.userMapper.selectByPopular(record);
        return list;

    }
    @Override
    public Pagination<User> selectByRoleIdPage(User user) {
        List<User> list = this.userMapper.selectByRoleIdPage(user);
        return new Pagination<User>(list, user.getPageParameter());
    }

    /**
     */
    @Override
    public List<User> selectByRoleIdNoPage(User user) {
        return this.userMapper.selectByRoleIdPage(user);
    }

    @Override
    public List<User> selectByManagerId(Integer managerUserId) {
        return this.userMapper.selectByManagerId(managerUserId);
    }

    @Override
    public Pagination<User> selectAllMobileSalesListByPage(User user) {
        List<User> list = this.userMapper.selectAllMobileSalesListByPage(user);
        return new Pagination<User>(list, user.getPageParameter());
    }

}
