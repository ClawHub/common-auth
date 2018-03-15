package com.clawhub.auth;

import com.clawhub.auth.entity.SysPermission;
import com.clawhub.auth.entity.SysUser;

import java.util.List;
import java.util.Set;

/**
 * <Description> 权限管理相关接口，CURD <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月06日<br>
 */
public interface PermissionFacade {

    /**
     * Description: 根据用户信息获取权限列表 <br>
     *
     * @param userInfo userInfo
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    Set<String> findPermissionsByUser(SysUser userInfo);

    /**
     * Description: 获取所有权限列表 <br>
     *
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<SysPermission> getAllPermissions();

    /**
     * Description: 插入权限 <br>
     *
     * @param sysPermission sysPermission
     * @author LiZhiming <br>
     * @taskId <br>
     */
    void insertPermission(SysPermission sysPermission);
}
