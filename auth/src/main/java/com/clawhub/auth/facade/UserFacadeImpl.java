package com.clawhub.auth.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.clawhub.auth.UserFacade;
import com.clawhub.auth.entity.SysUser;
import com.clawhub.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <Description> 用户管理相关接口实现 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月08日<br>
 */
@Service
public class UserFacadeImpl implements UserFacade {

    /**
     * The Logger.
     */
    private Logger logger = LoggerFactory.getLogger(UserFacadeImpl.class);
    /**
     * The User service.
     */
    @Autowired
    private UserService userService;

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
        logger.info("UserFacadeImpl.findByUsername");
        logger.info("username :{}", username);
        return userService.findByUsername(username);
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
    /**
     * Query all sys user list.
     *
     * @return the list
     */
    @Override
    public List<SysUser> queryAllSysUser() {
        logger.info("UserFacadeImpl.queryAllSysUser");
        return userService.queryAllSysUser();
    }
}