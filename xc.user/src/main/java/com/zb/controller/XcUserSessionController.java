package com.zb.controller;

import com.zb.pojo.XcUser;
import com.zb.service.XcUserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author YuanHaiZhao
 * @Description TODO
 * @date 2020/6/9
 * @Version v1.0
 */
@RestController
@CrossOrigin
public class XcUserSessionController {

    @Autowired(required = false)
    private XcUserSessionService xcUserSessionService;

    @PostMapping(value = "/getXcUserById")
    public XcUser getXcUserById(String token){
        return xcUserSessionService.getXcUserById(token);
    }

    @PostMapping(value = "/sendPhoneMsg")
    public String sendPhoneMsg(String phone, HttpSession session){
        return xcUserSessionService.sendPhoneMsg(phone, session);
    }

    @PostMapping(value = "/verifPhoneMsg")
    public String verifPhoneMsg(String phone, String code, HttpSession session){
        return xcUserSessionService.verifPhoneMsg(phone, code, session);
    }
}
