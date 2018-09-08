package com.clawhub.auth.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.clawhub.auth.TokenFacade;
import com.clawhub.redis.core.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

/**
 * <Description> token服务<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -09-07 <br>
 */
@Component
public class TokenService {

    /**
     * The Redis template.
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * The Token facade.
     */
    @Reference
    private TokenFacade tokenFacade;


    /**
     * Save token info.
     *
     * @param username the username
     * @param token    the token
     */
    public void saveTokenInfo(String username, Serializable token) {
        String infoKey = "info:" + token;
        Map<String, Object> info = tokenFacade.getInfo(username);
        redisTemplate.set(infoKey, JSONObject.toJSONString(info), "NX", "EX", 30 * 60L);
    }

    /**
     * Del token info.
     *
     * @param token the token
     */
    public void delTokenInfo(Serializable token) {
        String infoKey = "info:" + token;
        redisTemplate.del(infoKey);
    }

    /**
     * Gets info.
     *
     * @param token the token
     * @return the info
     */
    public JSONObject getInfo(Serializable token) {
        String infoKey = "info:" + token;
        return JSONObject.parseObject(redisTemplate.get(infoKey));
    }


}
