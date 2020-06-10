package com.zb.controller;

import com.zb.pojo.XcUser;
import com.zb.service.XcUserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YuanHaiZhao
 * @Description TODO
 * @date 2020/6/9
 * @Version v1.0
 */
@RestController
public class XcUserSessionController {

    @Autowired(required = false)
    private XcUserSessionService xcUserSessionService;

    @PostMapping(value = "/getXcUserById")
    public XcUser getXcUserById(String token){
        return xcUserSessionService.getXcUserById(token);
    }
}
