package com.clawhub.auth.service.impl;

import com.clawhub.auth.entity.RoleResource;
import com.clawhub.auth.mapper.RoleResourceMapper;
import com.clawhub.auth.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <Description> 角色资源服务实现<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/9/12 <br>
 */
@Service
public class RoleResourceServiceImpl implements RoleResourceService {
    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public void add(List<String> resourceIds, RoleResource roleResource) {
        roleResourceMapper.add(resourceIds, roleResource);
    }

    @Override
    public int batchDelByRoleIds(List<String> roleIds, RoleResource roleResource) {

        return roleResourceMapper.batchUpdateForDelByRoleIds(roleIds, roleResource);
    }

    @Override
    public int batchDelByResourceIds(List<String> resourceIds, RoleResource roleResource) {
        return roleResourceMapper.batchUpdateForDelByResourceIds(resourceIds, roleResource);
    }
}
