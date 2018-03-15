/**************************************************************************************** 
 南京小视科技有限公司           
 ****************************************************************************************/
package com.clawhub.auth.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.clawhub.auth.PermissionFacade;
import com.clawhub.auth.entity.SysPermission;
import com.clawhub.auth.entity.SysUser;
import com.clawhub.auth.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * <Description> 权限管理接口实现 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月08日<br>
 */
@Service
public class PermissionFacadeImpl implements PermissionFacade {

    /**
     * The Permission service.
     */
    @Autowired
    private PermissionService permissionService;

    /**
     * Description: 根据用户信息获取权限列表 <br>
     *
     * @param userInfo userInfo
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public Set<String> findPermissionsByUser(SysUser userInfo) {
        return permissionService.findPermissionsByUser(userInfo);
    }

    /**
     * Description: 获取所有权限列表 <br>
     *
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public List<SysPermission> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    /**
     * Description: 插入权限 <br>
     *
     * @param sysPermission sysPermission
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public void insertPermission(SysPermission sysPermission) {
        //permissionService.insertPermission(sysPermission);
    }
}