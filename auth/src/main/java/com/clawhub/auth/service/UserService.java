package com.clawhub.auth.service;

import com.clawhub.auth.entity.SysUser;

import java.util.List;

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
     * Query all sys user list.
     *
     * @return the list
     */
    List<SysUser> queryAllSysUser();
}
