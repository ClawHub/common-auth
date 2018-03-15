/**************************************************************************************** 
 南京小视科技有限公司           
 ****************************************************************************************/
package com.clawhub.auth.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.clawhub.auth.RoleFacade;
import com.clawhub.auth.entity.SysUser;
import com.clawhub.auth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * <Description> 角色接口实现 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月08日<br>
 */
@Service
public class RoleFacadeImpl implements RoleFacade {

    /**
     * The Role service.
     */
    @Autowired
    private RoleService roleService;

    /**
     * Description: Find roles by user <br>
     *
     * @param userInfo user info
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public Set<String> findRolesByUser(SysUser userInfo) {
        return roleService.findRolesByUser(userInfo);
    }
}