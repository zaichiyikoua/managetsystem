package com.zaichiyikou.starter.system.config;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/*
 * 因为做的项目是前后分离的。
 * 需要重写shiro获取sessionId的方式
 */

public class ShiroSessionManager extends DefaultWebSessionManager {
    /*
     * 原来的未分离之前是使用cookie中读取sessionId以此来维持会话
     * 现在是在ajax的请求头中传递sessionId
     */
    
    private static final String AUTHORIZATION = "Authorization";
    
    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
 
    public ShiroSessionManager() {
        super();
    }

    
    @Override
    public Serializable getSessionId(ServletRequest request, ServletResponse response) {
        // TODO Auto-generated method stub
        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        //如果请求头中有 Authorization 则其值为sessionId
        if (!StringUtils.isEmpty(id)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        } else {
            //否则按默认规则从cookie取sessionId
            return super.getSessionId(request, response);
        }
    }
}
