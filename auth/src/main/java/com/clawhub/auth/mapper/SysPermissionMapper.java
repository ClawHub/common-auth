package com.clawhub.auth.mapper;

import com.clawhub.auth.common.IMapper;
import com.clawhub.auth.entity.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Sys permission mapper.
 */
public interface SysPermissionMapper extends IMapper<SysPermission> {
    /**
     * Description: 根据权限ID列表获取权限列表 <br>
     *
     * @param permissionIds permission ids
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<String> findPermissionsByIds(@Param(value = "list") List<String> permissionIds);

    /**
     * Description:获取所有权限列表 <br>
     *
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<SysPermission> selectAllPermissions();
}