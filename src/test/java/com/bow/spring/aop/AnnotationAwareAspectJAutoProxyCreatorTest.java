package com.bow.spring.aop;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @see BeanNameAutoProxyCreatorTest
 * @see DefaultAdvisorAutoProxyCreatorTest
 * @author vv
 * @since 2017/2/1.
 */
@Configuration
public class AnnotationAwareAspectJAutoProxyCreatorTest {
    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean(name = "annotationAspect")
    public AnnotationAspect aspect() {
        return new AnnotationAspect();
    }

    /**
     * 注意此处只要配置AnnotationAwareAspectJAutoProxyCreator
     * bean就开启了aspectJ注解的AutoProxyCreator
     * 
     * @return
     */
    @Bean
    public AnnotationAwareAspectJAutoProxyCreator autoProxyCreator() {
        return new AnnotationAwareAspectJAutoProxyCreator();
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AnnotationAwareAspectJAutoProxyCreatorTest.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.addUser();
    }
}