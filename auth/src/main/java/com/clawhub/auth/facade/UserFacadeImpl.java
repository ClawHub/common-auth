package com.clawhub.auth.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.clawhub.auth.UserFacade;
import com.clawhub.auth.entity.SysUser;
import com.clawhub.auth.entity.UserRole;
import com.clawhub.auth.service.UserRoleService;
import com.clawhub.auth.service.UserService;
import com.clawhub.auth.vo.SearchModel;
import com.clawhub.constants.StatusConstant;
import com.clawhub.util.IDGenarator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <Description> 用户管理相关接口实现 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月08日<br>
 */
@Service
public class UserFacadeImpl implements UserFacade {

    /**
     * The User service.
     */
    @Autowired
    private UserService userService;
    /**
     * The User role service.
     */
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public SysUser findByUsername(String username) {
        return userService.findByUsername(username);
    }


    @Override
    public String queryUserByPage(SearchModel searchModel, SysUser sysUser) {
        return userService.queryUserByPage(searchModel, sysUser);
    }

    @Override
    public void addUser(SysUser sysUser, List<String> roleIds) {
        userService.addUser(sysUser);
        UserRole userRole = new UserRole();
        userRole.setCreateOperatorId(sysUser.getCreateOperatorId());
        userRole.setCreateOperatorName(sysUser.getCreateOperatorName());
        userRole.setId(IDGenarator.getID());
        userRole.setCreateTime(System.currentTimeMillis());
        userRole.setIsDelete(StatusConstant.UN_DELETED);
        userRole.setUserId(sysUser.getUserId());
        userRoleService.add(roleIds, userRole);
    }

    @Override
    public void batchDelUser(List<String> userIds, SysUser currentUser) {
        SysUser sysUser = new SysUser();
        sysUser.setUpdateOperatorId(currentUser.getUserId());
        sysUser.setUpdateOperatorName(currentUser.getUsername());
        sysUser.setUpdateTime(System.currentTimeMillis());
        sysUser.setIsDelete(StatusConstant.DELETED);
        userService.batchDelUser(sysUser, userIds);
        UserRole userRole = new UserRole();
        userRole.setUpdateOperatorId(currentUser.getUserId());
        userRole.setUpdateOperatorName(currentUser.getUsername());
        userRole.setUpdateTime(System.currentTimeMillis());
        userRole.setIsDelete(StatusConstant.DELETED);
        userRoleService.batchDel(userRole, userIds);
    }
}