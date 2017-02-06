package com.bow.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

import java.util.List;

public class MyRealm1 implements Realm {

    @Override
    public String getName() {
        return "MyRealm1";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        if (!"vv".equals(username)) {
            throw new UnknownAccountException();
        }
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();
        }
        // 如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
