package com.clawhub.auth.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.clawhub.auth.ResourceFacade;
import com.clawhub.auth.RoleFacade;
import com.clawhub.auth.UserFacade;
import com.clawhub.auth.entity.SysResource;
import com.clawhub.auth.entity.SysUser;
import com.clawhub.redis.core.RedisTemplate;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * <Description> token服务<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -09-07 <br>
 */
@Component
public class TokenService {
    /**
     * The Logger.
     */
    private Logger logger = LoggerFactory.getLogger(TokenService.class);


    /**
     * The Redis template.
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * The User facade.
     */
    @Reference
    private UserFacade userFacade;

    /**
     * The Role facade.
     */
    @Reference
    private RoleFacade roleFacade;
    /**
     * The Resource facade.
     */
    @Reference
    private ResourceFacade resourceFacade;

    /**
     * Save token info.
     *
     * @param username the username
     * @param token    the token
     */
    public void saveTokenInfo(String username, Serializable token) {
        //根据用户名获取用户信息
        SysUser sysUser = userFacade.findByUsername(username);
        saveUser(sysUser, token);
        saveRole(sysUser.getUserId(), token);
        saveResource(sysUser.getUserId(), token);
    }

    /**
     * Del token info.
     *
     * @param token the token
     */
    public void delTokenInfo(Serializable token) {
        deleteUser(token);
        deleteRole(token);
        deleteResource(token);
    }

    /**
     * Save user.
     *
     * @param sysUser the sys user
     * @param token   the token
     */
    private void saveUser(SysUser sysUser, Serializable token) {
        //获取用户信息放入redis
        String userKey = "user:" + token;
        //30分钟
        redisTemplate.set(userKey, JSONObject.toJSONString(sysUser), "NX", "EX", 30 * 60L);
    }

    /**
     * Gets user info.
     *
     * @param token the token
     * @return the user info
     */
    public SysUser getUserInfo(Serializable token) {
        String userKey = "user:" + token;
        String userInfo = redisTemplate.get(userKey);
        if (StringUtils.isBlank(userInfo)) {
            return new SysUser();
        }
        return JSONObject.parseObject(userInfo, SysUser.class);
    }

    /**
     * Delete user.
     *
     * @param token the token
     */
    private void deleteUser(Serializable token) {
        String userKey = "user:" + token;
        redisTemplate.del(userKey);
    }

    /**
     * Save role.
     *
     * @param userId the user id
     * @param token  the token
     */
    private void saveRole(String userId, Serializable token) {
        //根据用户id获取角色信息
        Set<String> roles = roleFacade.findRoleNamesByUserId(userId);
        String roleKey = "role:" + token;
        redisTemplate.set(roleKey, JSONObject.toJSONString(roles), "NX", "EX", 30 * 60L);
    }

    /**
     * Gets roles.
     *
     * @param token the token
     * @return the roles
     */
    public Set<String> getRoles(Serializable token) {
        String roleKey = "role:" + token;
        String roles = redisTemplate.get(roleKey);
        if (StringUtils.isBlank(roles)) {
            return Collections.emptySet();
        }
        return JSONObject.parseObject(roles, HashSet.class);
    }

    /**
     * Delete role.
     *
     * @param token the token
     */
    private void deleteRole(Serializable token) {
        String roleKey = "role:" + token;
        redisTemplate.del(roleKey);
    }

    /**
     * Save resource.
     *
     * @param userId the user id
     * @param token  the token
     */
    private void saveResource(String userId, Serializable token) {
        //根据用户id获取资源信息
        Set<SysResource> resources = resourceFacade.findPermissionsByUserId(userId);
        String resourceKey = "resource:" + token;
        redisTemplate.set(resourceKey, JSONObject.toJSONString(resources), "NX", "EX", 30 * 60L);
    }

    public Set<SysResource> getResource(Serializable token) {
        String resourceKey = "resource:" + token;
        String resources = redisTemplate.get(resourceKey);
        if (StringUtils.isBlank(resources)) {
            return Collections.emptySet();
        }
        return JSONObject.parseObject(resources, HashSet.class);
    }

    /**
     * Delete resource.
     *
     * @param token the token
     */
    private void deleteResource(Serializable token) {
        String resourceKey = "resource:" + token;
        redisTemplate.del(resourceKey);
    }


}
