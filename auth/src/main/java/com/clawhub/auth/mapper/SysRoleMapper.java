package com.clawhub.auth.mapper;

import com.clawhub.auth.entity.SysRole;
import com.clawhub.auth.common.IMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Sys role mapper.
 */
public interface SysRoleMapper extends IMapper<SysRole> {
    /**
     * Description: 根据角色ID列表获取角色名称列表 <br>
     *
     * @param roleIds role ids
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<String> findRoleNamesByRoleIds(@Param(value = "list") List<String> roleIds);
}