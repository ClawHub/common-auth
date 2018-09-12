package com.clawhub.auth.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.clawhub.auth.RoleFacade;
import com.clawhub.auth.entity.RoleResource;
import com.clawhub.auth.entity.SysRole;
import com.clawhub.auth.entity.SysUser;
import com.clawhub.auth.entity.UserRole;
import com.clawhub.auth.service.RoleResourceService;
import com.clawhub.auth.service.RoleService;
import com.clawhub.auth.service.UserRoleService;
import com.clawhub.auth.vo.SearchModel;
import com.clawhub.constants.StatusConstant;
import com.clawhub.util.IDGenarator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
     * The Role resource service.
     */
    @Autowired
    private RoleResourceService roleResourceService;
    /**
     * The User role service.
     */
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public Set<String> findRoleNamesByUserId(String userId) {
        return roleService.findRoleNamesByUserId(userId);
    }

    @Override
    public String queryRoleByPage(SearchModel searchModel, SysRole sysRole) {
        return roleService.queryRoleByPage(searchModel, sysRole);
    }

    @Override
    @Transactional
    public void addRole(SysRole sysRole, List<String> resourceIds) {
        roleService.addRole(sysRole);
        RoleResource roleResource = new RoleResource();
        roleResource.setCreateOperatorId(sysRole.getCreateOperatorId());
        roleResource.setCreateOperatorName(sysRole.getCreateOperatorName());
        roleResource.setCreateTime(System.currentTimeMillis());
        roleResource.setIsDelete(StatusConstant.UN_DELETED);
        roleResource.setId(IDGenarator.getID());
        roleResource.setRoleId(sysRole.getRoleId());
        roleResourceService.add(resourceIds, roleResource);
    }

    @Override
    @Transactional
    public void batchDelRole(List<String> roleIds, SysUser currentUser) {
        //删除role
        SysRole sysRole = new SysRole();
        sysRole.setUpdateOperatorId(currentUser.getUserId());
        sysRole.setUpdateOperatorName(currentUser.getUsername());
        sysRole.setUpdateTime(System.currentTimeMillis());
        sysRole.setIsDelete(StatusConstant.DELETED);
        roleService.batchDel(roleIds, sysRole);
        //删除role-resource对应关系
        RoleResource roleResource = new RoleResource();
        roleResource.setUpdateOperatorId(currentUser.getUserId());
        roleResource.setUpdateOperatorName(currentUser.getUsername());
        roleResource.setUpdateTime(System.currentTimeMillis());
        roleResource.setIsDelete(StatusConstant.DELETED);
        roleResourceService.batchDelByRoleIds(roleIds, roleResource);
        //删除role-user对应关系
        UserRole userRole = new UserRole();
        userRole.setUpdateOperatorId(currentUser.getUserId());
        userRole.setUpdateOperatorName(currentUser.getUsername());
        userRole.setUpdateTime(System.currentTimeMillis());
        userRole.setIsDelete(StatusConstant.DELETED);
        userRoleService.batchDelByRoleIds(userRole, roleIds);
    }
}