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
}