package com.zaichiyikou.starter.system.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zaichiyikou.starter.system.common.ActiveUser;
import com.zaichiyikou.starter.system.pojo.SysUser;
import com.zaichiyikou.starter.system.service.SysUserService;

@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService userService;

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.getClass().getSimpleName();
    }

    /*
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // TODO Auto-generated method stub
        String username = token.getPrincipal().toString();
        // wrapper条件构造器
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        // 条件匹配loginname
        queryWrapper.eq("loginname", username);
        SysUser user = userService.getOne(queryWrapper);
        // 非空
        if (null != user) {
            ActiveUser activeUser = new ActiveUser();
            activeUser.setUser(user);

            // 加盐 等同于uuid
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
            // SimpleAuthenticationInfo是AuthenticationInfo的实现
            // 这个对象最重要的就是第二个参数，是由shiro去判断密码是否相等
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser, user.getPwd(), credentialsSalt,
                    getName());
            return info;
        }
        // 用户不存在 这里null shiro会抛出异常
        return null;
    }

}
