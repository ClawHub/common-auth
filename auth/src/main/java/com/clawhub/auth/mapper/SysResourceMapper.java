package com.clawhub.auth.mapper;

import com.clawhub.auth.entity.SysResource;
import com.clawhub.common.IMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Sys Resource mapper.
 */
public interface SysResourceMapper extends IMapper<SysResource> {
    /**
     * Description: 根据资源ID列表获取权限列表 <br>
     *
     * @param resourceIds 资源ID列表
     * @return list
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<String> findResourcesByIds(@Param(value = "list") List<String> resourceIds);

    /**
     * Description:获取所有权限列表 <br>
     *
     * @author LiZhiming <br>
     * @taskId <br>
     */
    List<SysResource> selectAllResource();
}