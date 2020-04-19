package com.zaichiyikou.starter.system.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;

/*
 * web相关的工具类
 */
public class WebUtils {

    /*
     * 使用解耦的方式来拿到requset
     * 
     * @return HttpServletRequest request
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder.getRequestAttributes();
        return request;
    }

    /*
     * 拿到session
     * @return HttpSession session
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }
}
