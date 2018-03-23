package com.peony.peonydata.userRole.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peony.peonydata.userRole.dao.UserRoleMapper;
import com.peony.peonydata.userRole.model.UserRole;

/**
 * 用户-角色管理
 *
 * @date：
 *
 * @author jhj
 * @version 1
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper; // 用户-角色mapper

    @Override
    public int insert(UserRole record) {
        return this.userRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return this.userRoleMapper.insertSelective(record);
    }

    @Override
    public int deleteByRoleIdAndUserId(UserRole record) {
        return this.userRoleMapper.deleteByRoleIdAndUserId(record);
    }

    @Override
    public int deleteByUserId(Integer userId) {
        return this.userRoleMapper.deleteByUserId(userId);
    }

    @Override
    public int deleteByRoleId(Integer roleId) {
        return this.userRoleMapper.deleteByRoleId(roleId);
    }

    @Override
    public int updateUserRole(UserRole record) {
        if (record != null) {
            int userId = record.getUserId();
            String roleIds = record.getRoleIds();
            String[] arrayRoleId = roleIds.split(",");
            if (roleIds != null && !"".equals(roleIds) && userId > 0) {
                this.userRoleMapper.deleteByUserId(userId);
                // save
                for (String roleid : arrayRoleId) {
                    UserRole ur = new UserRole();
                    ur.setRoleId(Integer.valueOf(roleid));
                    ur.setUserId(userId);
                    this.userRoleMapper.insert(ur);
                }

            } else {
                this.userRoleMapper.deleteByUserId(userId);
            }

        }

        return 0;

    }

    @Override
    public int saveUserRole(UserRole record) {

        Integer roleId = record.getRoleId();
        String pre_userIds = record.getPre_userIds();
        if (pre_userIds != null && !"".equals(pre_userIds)) {
            String arryPreUserIds[] = pre_userIds.split(",");
            for (int i = 0; i < arryPreUserIds.length; i++) {
                UserRole ur = new UserRole();
                ur.setRoleId(roleId);
                ur.setUserId(Integer.valueOf(arryPreUserIds[i]));
                this.userRoleMapper.deleteByRoleIdAndUserId(ur);

            }
        }

        String userIds = record.getUserIds();// 当前userIds
        if (userIds != null && !"".equals(userIds)) {
            String arryUserIds[] = userIds.split(",");
            for (int i = 0; i < arryUserIds.length; i++) {
                if (arryUserIds[i] != null && !"".equals(arryUserIds[i])) {
                    UserRole ur = new UserRole();
                    ur.setRoleId(roleId);
                    ur.setUserId(Integer.valueOf(arryUserIds[i]));
                    this.userRoleMapper.insert(ur);
                }
            }
        }

        return 0;
    }

}