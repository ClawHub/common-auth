package com.clawhub.auth;

import com.clawhub.auth.entity.SysResource;
import com.clawhub.auth.entity.SysUser;

import java.util.List;
import java.util.Set;

/**
 * <Description> 资源管理相关接口，CURD <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月06日<br>
 */
public interface ResourceFacade {

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

    /**
     * Description: 插入资源 <br>
     *
     * @param sysResource sysResource
     * @author LiZhiming <br>
     * @taskId <br>
     */
    void insertResource(SysResource sysResource);
}
