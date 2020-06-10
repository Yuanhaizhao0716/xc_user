package com.zb.service;

import com.zb.pojo.XcUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author YuanHaiZhao
 * @Description TODO
 * @date 2020/6/9
 * @Version v1.0
 */
public interface XcUserSessionService {

    public XcUser getXcUserById(String token);

    public String sendPhoneMsg(String phone, HttpSession session);

    public String verifPhoneMsg(String phone, String code, HttpSession session);
}
