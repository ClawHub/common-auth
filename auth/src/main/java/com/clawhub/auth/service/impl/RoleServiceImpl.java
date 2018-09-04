package com.clawhub.auth.service.impl;

import com.clawhub.auth.entity.SysRole;
import com.clawhub.auth.entity.SysUser;
import com.clawhub.auth.mapper.SysRoleMapper;
import com.clawhub.auth.mapper.UserRoleMapper;
import com.clawhub.auth.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <Description> 角色管理 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月07日<br>
 */
@Service
public class RoleServiceImpl implements RoleService {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    /**
     * The Sys role mapper.
     */
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * The User role mapper.
     */
    @Autowired
    private UserRoleMapper userRoleMapper;

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
        logger.info("RoleServiceImpl.findRolesByUser");
        if (userInfo == null) {
            return Collections.EMPTY_SET;
        }
        logger.info("userId :{}", userInfo.getUserId());
        //根据用户id获取角色ID列表
        List<String> roleIds = userRoleMapper.findRoleIdsByUserId(userInfo.getUserId());

        if (CollectionUtils.isEmpty(roleIds)) {
            return Collections.EMPTY_SET;
        }
        logger.info("roleIds.size :{}", roleIds.size());
        //根据角色ID列表获取角色名称列表
        List<String> roleNames = sysRoleMapper.findRoleNamesByRoleIds(roleIds);
        return new HashSet<>(roleNames);
    }

    @Override
    public List<SysRole> queryAllSysRole() {
        return sysRoleMapper.selectAll();
    }
}