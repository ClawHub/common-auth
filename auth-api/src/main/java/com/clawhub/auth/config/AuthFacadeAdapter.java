package com.clawhub.auth.config;

import com.alibaba.dubbo.config.annotation.Reference;
import com.clawhub.auth.PermissionFacade;
import com.clawhub.auth.entity.SysPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <Description> 适配器 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月08日<br>
 */
public class AuthFacadeAdapter {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(AuthFacadeAdapter.class);
    /**
     * The Permission facade.
     */
    @Reference
    private PermissionFacade permissionFacade;


    /**
     * Description: Get permission facade <br>
     *
     * @return permission facade
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public PermissionFacade getPermissionFacade() {
        return permissionFacade;
    }


    /**
     * 初始化权限
     */
    public Map<String, String> loadFilterChainDefinitions() {
        // 权限控制map.从数据库获取
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        List<SysPermission> permissions = permissionFacade.getAllPermissions();
        //测试：将鉴权关闭
        filterChainDefinitionMap.put("/**", "anon");

//        filterChainDefinitionMap.put("/authCtr/logout", "logout");
//        filterChainDefinitionMap.put("/authCtr/login", "anon");
//        for (SysPermission permission : permissions) {
//            logger.info("=======================权限配置开始================================");
//            logger.info("Size :{}", permissions.size());
//            logger.info("Url() :{}", permission.getUrl());
//            logger.info("Permission() :{}", permission.getPermission());
//            filterChainDefinitionMap.put(permission.getUrl(), "perms[" + permission.getPermission() + "]");
//            logger.info("=======================权限配置结束================================");
//        }
//        filterChainDefinitionMap.put("/**", "authc");
        return filterChainDefinitionMap;
    }
}