package com.bow.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticatorTest {

    @Test
    public void testFirstOneSuccessfulStrategyWithSuccess() {
        login("classpath:shiro.ini");
        Subject subject = SecurityUtils.getSubject();

        // 得到一个身份集合，其包含了第一个Realm验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals();
        Assert.assertEquals(1, principalCollection.asList().size());
    }

    private void login(String configFile) {
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("vv", "123");
        subject.login(token);
    }

    @After
    public void tearDown() throws Exception {
        // 退出时请解除绑定Subject到线程 否则对下次测试造成影响
        ThreadContext.unbindSubject();
    }

}
