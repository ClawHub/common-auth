package com.clawhub.auth.service;

import com.clawhub.auth.entity.SysRole;

import java.util.List;
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
     * @param userId userId
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    Set<String> findRoleNamesByUserId(String userId);

    /**
     * 查询所有角色列表
     *
     * @return 所有角色列表
     */
    List<SysRole> queryAllSysRole();
}
