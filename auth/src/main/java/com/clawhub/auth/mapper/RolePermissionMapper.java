package com.clawhub.auth.mapper;

import com.clawhub.auth.common.IMapper;
import com.clawhub.auth.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Role permission mapper.
 */
public interface RolePermissionMapper extends IMapper<RolePermission> {
    /**
     * Description: 根据角色ID列表获取权限ID列表<br>
     *
     * @param roleIds role ids
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<String> findPermissionIdsByRoleIds(@Param(value = "list") List<String> roleIds);
}