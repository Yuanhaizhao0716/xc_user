package com.zb.service.impl;

import com.zb.feign.XcUserFeignClient;
import com.zb.mapper.XcUserMapper;
import com.zb.pojo.XcUser;
import com.zb.service.XcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YuanHaiZhao
 * @Description TODO
 * @date 2020/6/6
 * @Version v1.0
 */
@Service
public class XcUserServiceImpl implements XcUserService {

    @Autowired(required = false)
    private XcUserMapper xcUserMapper;
    @Autowired(required = false)
    private XcUserFeignClient xcUserFeignClient;

    @Override
    public XcUser getXcUserById(Long id) throws Exception {
        XcUser user = xcUserMapper.getXcUserById(id);
        return user;
    }

    @Override
    public XcUser getXcUserListByMap(String username, String password) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("username",username);
        param.put("password",password);
        List<XcUser> XcUserList=xcUserMapper.getXcUserListByMap(param);
        if (XcUserList.size()>0){
            return XcUserList.get(0);
        }
        return null;
    }

    @Override
    public Integer insertXcUser(XcUser xcUser) throws Exception {
        Integer num = xcUserMapper.insertXcUser(xcUser);
        return num;
    }

    @Override
    public Integer updateXcUser(XcUser xcUser) throws Exception {
        Integer num = xcUserMapper.updateXcUser(xcUser);
        return num;
    }

    @Override
    public Integer deleteXcUserById(Long id) throws Exception {
        Integer num = xcUserMapper.deleteXcUserById(id);
        return num;
    }
}
