package com.zb.service.impl;

import com.alibaba.fastjson.JSON;
import com.zb.pojo.XcUser;
import com.zb.service.XcUserSessionService;
import com.zb.service.XcUserTokenService;
import com.zb.util.RedisUtil;
import com.zb.util.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @Autowired
    private SMSService smsService;
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

    @Override
    public String sendPhoneMsg(String phone, HttpSession session) {
        int code = (int)(Math.random()*10000);
        System.out.println(code);
        //phone:18361211916 templated:模板编号 new String[]{code+"","1"}：随机数
        //smsService.send(phone,"1", new String[]{code+"","1"});
        String key = "phone:" + phone;
        session.setAttribute(key, code + "");
        return "success";
    }

    @Override
    public String verifPhoneMsg(String phone, String code, HttpSession session) {
        String key = "phone:" + phone;
        String strCode = (String) session.getAttribute(key);
        if (!strCode.equals(code)) {
            return "error";
        }
        return "success";
    }
}
