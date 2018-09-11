package com.clawhub.auth.service;

import com.clawhub.auth.entity.SysUser;
import com.clawhub.auth.vo.SearchModel;

/**
 * <Description> 用户管理接口 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月06日<br>
 */
public interface UserService {
    /**
     * Description: Find by username <br>
     *
     * @param username username
     * @return sys user
     * @author LiZhiming <br>
     * @taskId <br>
     */
    SysUser findByUsername(String username);

    /**
     * 分页查询用户信息
     *
     * @param searchModel 查询模型
     * @param sysUser     用户模型
     * @return 用户及分页信息
     */
    String queryUserByPage(SearchModel searchModel, SysUser sysUser);

    /**
     * 增加用户
     *
     * @param sysUser sysUser
     */
    void addUser(SysUser sysUser);
}
