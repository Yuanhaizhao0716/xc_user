package com.zb.service.impl;

import com.alibaba.fastjson.JSON;
import com.zb.pojo.XcUser;
import com.zb.service.XcUserSessionService;
import com.zb.service.XcUserTokenService;
import com.zb.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YuanHaiZhao
 * @Description TODO
 * @date 2020/6/9
 * @Version v1.0
 */
@Service
public class XcUserSessionServiceImpl implements XcUserSessionService {

    @Autowired(required = false)
    private RedisUtil redisUtil;

    @Override
    public XcUser getXcUserById(String token) {
        //String key = "token-" + token;
        if (redisUtil.hasKey(token)) {
            System.out.println("redis中查询信息");
            String json = redisUtil.get(token).toString();
            XcUser xcUser = JSON.parseObject(json, XcUser.class);
            return xcUser;
        }
        return null;
    }
}
