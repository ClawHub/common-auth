package com.clawhub.auth.mapper;

import com.clawhub.auth.entity.RoleResource;
import com.clawhub.common.IMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Role Resource mapper.
 */
public interface RoleResourceMapper extends IMapper<RoleResource> {
    /**
     * Description: 根据角色ID列表获取权限ID列表<br>
     *
     * @param roleIds role ids
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<String> findResourceIdsByRoleIds(@Param(value = "list") List<String> roleIds);
}