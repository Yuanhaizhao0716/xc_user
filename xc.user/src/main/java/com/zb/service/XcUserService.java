package com.zb.service;

import com.zb.pojo.XcUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author YuanHaiZhao
 * @Description TODO
 * @date 2020/6/6
 * @Version v1.0
 */
public interface XcUserService {

    public XcUser getXcUserById(Long id)throws Exception;

    public XcUser getXcUserListByMap(String username, String password)throws Exception;

    public Integer insertXcUser(XcUser xcUser)throws Exception;

    public Integer updateXcUser(XcUser xcUser)throws Exception;

    public Integer deleteXcUserById(Long id)throws Exception;
}
