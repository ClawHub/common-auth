/**************************************************************************************** 
 南京小视科技有限公司           
 ****************************************************************************************/
package com.clawhub.auth.service.impl;

import com.clawhub.auth.entity.SysUser;
import com.clawhub.auth.mapper.SysUserMapper;
import com.clawhub.auth.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <Description> 用户管理 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月07日<br>
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * The Sys user mapper.
     */
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * Description: Find by username <br>
     *
     * @param username username
     * @return sys user
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public SysUser findByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            return null;
        }
        logger.info("UserServiceImpl.findByUsername()");
        logger.info("username :{}", username);
        SysUser record = new SysUser();
        record.setUserName(username);
        return sysUserMapper.selectOne(record);
    }

    /**
     * Query all sys user list.
     *
     * @return the list
     */
    @Override
    public List<SysUser> queryAllSysUser() {
        logger.info("UserServiceImpl.queryAllSysUser()");
        return sysUserMapper.selectAll();
    }
}
