package com.clawhub.auth.service;

import com.clawhub.auth.entity.SysUser;

import java.util.Set;

/**
 * <Description> 角色管理接口 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月06日<br>
 */
public interface RoleService {
    /**
     * Description: Find roles by user <br>
     *
     * @param userInfo user info
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    Set<String> findRolesByUser(SysUser userInfo);
}
