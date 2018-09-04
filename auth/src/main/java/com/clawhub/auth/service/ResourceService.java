package com.clawhub.auth.service;

import com.clawhub.auth.entity.SysResource;
import com.clawhub.auth.entity.SysUser;

import java.util.List;
import java.util.Set;

/**
 * <Description> 资源管理接口 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月06日<br>
 */
public interface ResourceService {
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
     * Description: 获取所有资源列表 <br>
     *
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<SysResource> getAllResource();
}
