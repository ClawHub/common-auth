package com.clawhub.auth.service;

import com.clawhub.auth.entity.SysResource;

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
     * Description: 根据用户ID获取权限列表 <br>
     *
     * @param userId userId
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    Set<SysResource> findPermissionsByUserId(String userId);

    /**
     * Description: 获取所有资源列表 <br>
     *
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<SysResource> getAllResource();
}
