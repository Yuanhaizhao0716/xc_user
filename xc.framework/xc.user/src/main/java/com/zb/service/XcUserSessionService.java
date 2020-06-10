package com.zb.service;

import com.zb.pojo.XcUser;

/**
 * @author YuanHaiZhao
 * @Description TODO
 * @date 2020/6/9
 * @Version v1.0
 */
public interface XcUserSessionService {

    public XcUser getXcUserById(String token);
}
