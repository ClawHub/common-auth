package com.clawhub.auth.service;

import com.clawhub.auth.entity.UserRole;

import java.util.List;

/**
 * <Description> 用户角色服务<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/9/11 <br>
 */
public interface UserRoleService {

    /**
     * 单个用户，多个角色
     *
     * @param roleIds  多角色ID
     * @param userRole 用户校角色信息
     */
    void add(List<String> roleIds, UserRole userRole);

    /**
     * 批量删除角色用户关系
     *
     * @param userRole 角色用户关系
     * @param userIds  用户角色列表
     */
    int batchDel(UserRole userRole, List<String> userIds);
}
