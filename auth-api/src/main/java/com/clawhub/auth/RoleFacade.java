package com.clawhub.auth;

import com.clawhub.auth.entity.SysUser;

import java.util.Set;

/**
 * <Description> 角色管理相关接口，CURD <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月06日<br>
 */
public interface RoleFacade {
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
