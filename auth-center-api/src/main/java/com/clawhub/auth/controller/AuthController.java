package com.clawhub.auth.controller;

import com.alibaba.fastjson.JSONObject;
import com.clawhub.auth.entity.SysUser;
import com.clawhub.auth.service.TokenService;
import com.clawhub.util.json.JsonUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * <Description> 权限认证管理<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018年02月07日<br>
 */
@RestController
@RequestMapping("auth")
//@Api(value = "/auth", tags = "权限认证管理")
public class AuthController {
    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    /**
     * The Token service.
     */
    @Autowired
    private TokenService tokenService;

    /**
     * Description: 登录方法 <br>
     *
     * @param param param
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ApiOperation(notes = "登录", value = "登录", produces = "application/json")
    public String login(@RequestBody String param) {
        logger.info("AuthController.login");
        logger.info(param);
        SysUser userInfo = JSONObject.parseObject(param, SysUser.class);
        String username = userInfo.getUsername();
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, userInfo.getPassword());
        try {
            subject.login(usernamePasswordToken);
            //登录成功,获取token
            Serializable token = subject.getSession().getId();
            //用户，角色，权限资源入redis
            tokenService.saveTokenInfo(username, token);
            //返回给前端
            jsonObject.put("token", token);
            return JsonUtil.getSucc(jsonObject, "100000", null);
        } catch (IncorrectCredentialsException e) {
            return JsonUtil.getErrorJson("100001");
        } catch (LockedAccountException e) {
            return JsonUtil.getErrorJson("100002");
        } catch (AuthenticationException e) {
            return JsonUtil.getErrorJson("100003");
        } catch (Exception e) {
            return JsonUtil.getErrorJson("100004");
        }
    }


    /**
     * Description: 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面 <br>
     *
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @RequestMapping(value = "/unAuth")
//    @ApiOperation(notes = "未登录", value = "未登录", produces = "application/json")
    public String unauth() {
        logger.info("AuthController.unAuth");
        return JsonUtil.getErrorJson("100005");
    }

    /**
     * Description: 登出 <br>
     *
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @RequestMapping(value = "/logout")
//    @ApiOperation(notes = "登出", value = "登出", produces = "application/json")
    public void logout() {
        logger.info("AuthController.logout");
        Subject subject = SecurityUtils.getSubject();
        //判断是否登陆
        logger.info("subject:" + subject);
        if (subject.getPrincipal() != null) {
            //清除token相关
            Serializable token = subject.getSession().getId();
            tokenService.delTokenInfo(token);
            //logout
            subject.logout();
        }

        logger.info("AuthController.logout");
    }

    /**
     * Description: 未授权 <br>
     *
     * @return string
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @RequestMapping(value = "/unAuthorized")
//    @ApiOperation(notes = "未授权", value = "未授权", produces = "application/json")
    public String unAuthorized() {
        logger.info("AuthController.unAuthorized");
        return JsonUtil.getErrorJson("100006");
    }

}