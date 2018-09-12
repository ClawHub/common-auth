package com.clawhub.auth.service.impl;

import com.clawhub.auth.entity.UserRole;
import com.clawhub.auth.mapper.UserRoleMapper;
import com.clawhub.auth.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <Description> 用户角色服务实现<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/9/11 <br>
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    /**
     * The User role mapper.
     */
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void add(List<String> roleIds, UserRole userRole) {
        userRoleMapper.add(userRole, roleIds);
    }

    @Override
    public int batchDelByUserIds(UserRole userRole, List<String> userIds) {
        return userRoleMapper.batchUpdateForDelByUserIds(userRole, userIds);
    }

    @Override
    public int batchDelByRoleIds(UserRole userRole, List<String> roleIds) {
        return userRoleMapper.batchUpdateForDelByRoleIds(userRole, roleIds);
    }
}
