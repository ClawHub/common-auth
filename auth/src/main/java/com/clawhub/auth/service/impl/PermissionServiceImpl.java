/**************************************************************************************** 
 南京小视科技有限公司           
 ****************************************************************************************/
package com.clawhub.auth.service.impl;

import com.clawhub.auth.entity.SysPermission;
import com.clawhub.auth.entity.SysUser;
import com.clawhub.auth.mapper.RolePermissionMapper;
import com.clawhub.auth.mapper.SysPermissionMapper;
import com.clawhub.auth.mapper.UserRoleMapper;
import com.clawhub.auth.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <Description> 权限管理 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月07日<br>
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    /**
     * The Logger.
     */
    private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
    /**
     * The Sys permission mapper.
     */
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    /**
     * The Role permission mapper.
     */
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    /**
     * The User role mapper.
     */
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * Description: 根据用户信息获取权限列表<br>
     *
     * @param userInfo userInfo
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public Set<String> findPermissionsByUser(SysUser userInfo) {
        logger.info("PermissionServiceImpl.findPermissionsByUser");
        if (userInfo == null) {
            return Collections.EMPTY_SET;
        }
        // 根据用户id获取角色ID列表
        List<String> roleIds = userRoleMapper.findRoleIdsByUserId(userInfo.getUserId());
        logger.info("roleIds.size :{}", roleIds.size());
        if (CollectionUtils.isEmpty(roleIds)) {
            return Collections.EMPTY_SET;
        }
        //根据角色ID列表获取权限ID列表
        List<String> permissionIds = rolePermissionMapper.findPermissionIdsByRoleIds(roleIds);
        if (CollectionUtils.isEmpty(permissionIds)) {
            return Collections.EMPTY_SET;
        }
        logger.info("permissionIds.size :{}", permissionIds.size());
        //根据权限ID列表获取权限列表
        List<String> permissions = sysPermissionMapper.findPermissionsByIds(permissionIds);

        return new HashSet<>(permissions);
    }

    /**
     * Description: 获取所有权限列表 <br>
     *
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public List<SysPermission> getAllPermissions() {
        return sysPermissionMapper.selectAllPermissions();
    }
}