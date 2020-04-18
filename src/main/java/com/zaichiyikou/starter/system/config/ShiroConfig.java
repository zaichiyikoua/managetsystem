package com.zaichiyikou.starter.system.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zaichiyikou.starter.system.pojo.SysUser;
import com.zaichiyikou.starter.system.realm.UserRealm;

/*
 * shiro配置
 */
@Configuration
public class ShiroConfig {

    /*
     * shirofilterFactoryBean
     */
    public ShiroFilterFactoryBean ShiroFilterFactoryBean(
            @Qualifier(value = "securityManager") DefaultSecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        filterFactoryBean.setSecurityManager(securityManager);
        // 配置过滤链
        Map<String, String> filterMap = new LinkedHashMap<>();
        /*
         * anon：无需认证就可以访问 
         * authc：必须认证了才能访问 
         * user：必须拥有“记住我”才能用 
         * perms：拥有某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         */
        // 退出过滤器 shiro后面一个参数是权限
        filterMap.put("/logout", "logout");
        // 登录
        filterMap.put("/login", "anon");
        filterMap.put("/*", "authc");
        // 单体项目的静态资源访问
        filterMap.put("/static/**", "anon");
        // 配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        filterFactoryBean.setLoginUrl("/unauth");
        // 未授权页面
        filterFactoryBean.setUnauthorizedUrl("/unauth");
        /*
         * 这是未分离的时候，后端控制跳转
         * 登录成功后要跳转的链接 
         * filterFactoryBean.setSuccessUrl("/index");
         */
        // 注册
        filterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return filterFactoryBean;
    }

    /*
     * defaultSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultSecurityManager DefaultSecurityManager(@Qualifier(value = "userRealm") UserRealm realm) {
        DefaultSecurityManager manager = new DefaultSecurityManager();
        // 加载userRealm
        manager.setRealm(realm);
        // 加载修改的SessionManager
        manager.setSessionManager(SessionManager());
        return manager;
    }

    
    /*
     * sessionManager
     */
    public SessionManager SessionManager() {
        // 返回
        SessionManager sessionManager = new ShiroSessionManager();
        return sessionManager;
    }
    
    /*
     * realm
     */
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
