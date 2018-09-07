package com.clawhub.auth.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.clawhub.auth.ResourceFacade;
import com.clawhub.auth.entity.SysResource;
import com.clawhub.auth.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * <Description> 资源管理接口实现 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月08日<br>
 */
@Service
public class ResourceFacadeImpl implements ResourceFacade {

    /**
     * The Resource service.
     */
    @Autowired
    private ResourceService resourceService;

    /**
     * Description: 根据用户ID获取权限列表 <br>
     *
     * @param userId userId
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public Set<SysResource> findPermissionsByUserId(String userId) {
        return resourceService.findPermissionsByUserId(userId);
    }

    /**
     * Description: 获取所有资源列表 <br>
     *
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public List<SysResource> getAllResource() {
        return resourceService.getAllResource();
    }

    /**
     * Description: 插入资源 <br>
     *
     * @param sysResource sysResource
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public void insertResource(SysResource sysResource) {
    }
}