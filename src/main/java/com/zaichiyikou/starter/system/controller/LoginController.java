package com.zaichiyikou.starter.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaichiyikou.starter.system.common.ActiveUser;
import com.zaichiyikou.starter.system.common.CommonResult;
import com.zaichiyikou.starter.system.utils.WebUtils;

/*
  * 登录控制器
 * @author zaichiyikoua
 * @since 2020-04-19
 */

@RestController
@RequestMapping("/system")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    /*
     * 登录接口
     * 
     * @param username 用户名
     * 
     * @param password 密码
     * 
     * @return CommonResult 返回信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public <T> CommonResult<String> login(@RequestParam(required = true) String username,
            @RequestParam(required = true) String password) {
        // 拿到shiro的subject对象
        Subject subject = SecurityUtils.getSubject();
        // 拿到token
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        try {
            // 登录
            subject.login(token);
            log.info("登录成功");
            // 拿到shiro的activeUser
            ActiveUser user = (ActiveUser) subject.getPrincipals();
            // 放进session中
            WebUtils.getSession().setAttribute("user", user.getUser());
            return CommonResult.success("登录成功");
        } catch (AuthenticationException e) {
            // TODO: handle exception
            e.printStackTrace();
            log.error("登录认证失败");
            return CommonResult.failed("登录认证失败");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            log.error("操作失败");
            return CommonResult.failed();
        }
    }
}
