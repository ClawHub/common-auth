package com.clawhub.auth.mapper;

import com.clawhub.auth.common.IMapper;
import com.clawhub.auth.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface User role mapper.
 */
public interface UserRoleMapper extends IMapper<UserRole> {
    /**
     * Description: 根据用户id获取角色ID列表 <br>
     *
     * @param userId user id
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<String> findRoleIdsByUserId(@Param(value = "userId") String userId);

    /**
     * 新增角色与用户对应关系
     *
     * @param userRole 用户信息
     * @param roleIds  角色列表
     */
    void add(@Param(value = "userRole") UserRole userRole, @Param(value = "roleIds") List<String> roleIds);
}