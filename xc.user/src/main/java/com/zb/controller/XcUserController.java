package com.zb.controller;

import com.zb.pojo.XcUser;
import com.zb.service.XcUserService;
import com.zb.service.XcUserTokenService;
import com.zb.util.SMSService;
import com.zb.vo.UserTokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author YuanHaiZhao
 * @Description TODO
 * @date 2020/6/6
 * @Version v1.0
 */
@RestController
@CrossOrigin
public class XcUserController {

    @Autowired(required = false)
    private XcUserService xcUserService;
    @Autowired(required = false)
    private XcUserTokenService xcUserTokenService;
    @Autowired(required = false)
    private SMSService smsService;
    /**
     * 管理员根据用户id查询用户个人信息 POST:http://localhost:8001/getXcUserById/id
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/getXcUserById/{id}")
    public XcUser getXcUserById(@PathVariable("id") String id) throws Exception {
        return xcUserService.getXcUserById(id);
    }

    /**
     * 用户或者管理员登录 POST:http://localhost:8001/getXcUserListByMap
     * @username
     * @password
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/getXcUserListByMap")
    public UserTokenVo getXcUserListByMap(String username, String password, HttpServletRequest request) throws Exception {
        //调用登录方法 返回登录的对象信息
        XcUser xcUser = xcUserService.getXcUserListByMap(username, password);
        //判断返回的对象是否为空
        if (xcUser!=null){
            //不为空 调用创建token的方法 获取请求头和当前登录对象的Username
            String token = xcUserTokenService.createToken(request.getHeader("user-agent"), xcUser.getUsername());
            //调用存储token的方法 将token和登录对象存储
            xcUserTokenService.saveToken(token, xcUser);
            //创建一个UserTokenVo工具对象
            UserTokenVo userTokenVo = new UserTokenVo();
            userTokenVo.setToken(token);
            userTokenVo.setExpTime(System.currentTimeMillis());
            userTokenVo.setCurrTime(System.currentTimeMillis() * 2 * 60 * 60);
            return userTokenVo;
        }
            return null;
    }

    /**
     * 用户注册或者管理员添加新的用户 POST:http://localhost:8001/insertXcUser
     * @param xcUser
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/insertXcUser")
    public Integer insertXcUser(XcUser xcUser) throws Exception {
        return xcUserService.insertXcUser(xcUser);
    }

    /**
     * 发送短信 输入手机号 18361211916
     * @param phone
     * @return
     *//*
    @PostMapping(value = "/sendPhoneMsg")
    public String sendPhoneMsg(String phone, HttpSession session){
        int code = (int)(Math.random()*10000);
        System.out.println(code);
        //phone:18361211916 templated:模板编号 new String[]{code+"","1"}：随机数
        smsService.send(phone,"1", new String[]{code+"","1"});
        String key = "phone:" + phone;
        session.setAttribute(key, code + "");
        return "success";
    }*/

    /**
     * 验证手机发送的验证码与接收的验证码是否一致
     * @param phone
     * @param code
     * @param session
     * @param request
     * @return
     *//*
    public String verif(String phone, String code, HttpSession session, HttpServletRequest request) {
        String key = "phone:" + phone;
        String strCode = (String) session.getAttribute(key);
        if (!strCode.equals(code)) {
            request.setAttribute("msg", "验证码不正确！");
            return "error";
        }
        return "success";
    }*/
    /**
     * 用户或者管理员修改个人信息 POST:
     * @param xcUser
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/updateXcUser")
    public Integer updateXcUser(XcUser xcUser) throws Exception {
        return xcUserService.updateXcUser(xcUser);
    }
    /**
     * 管理员根据用户id删除用户信息
     * @param id
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/deleteXcUserById/{id}")
    public Integer deleteXcUserById(@PathVariable("id") String id) throws Exception {
        return xcUserService.deleteXcUserById(id);
    }

}
