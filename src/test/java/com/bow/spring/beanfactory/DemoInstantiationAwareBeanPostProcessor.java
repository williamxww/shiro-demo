package com.bow.spring.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 * 测试InstantiationAwareBeanPostProcessor 在bean的实例化和初始化前后放置扩展点<br/>
 *
 * 
 * @author vv
 * @since 2017/2/1.
 */
public class DemoInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    private void log(String msg) {
        System.out.println(msg);
    }

    /**
     * 若此方法返回的结果不为null，则会中断后面bean对象的创建过程
     * 
     * @param beanClass
     *            beanClass
     * @param beanName
     *            beanName
     * @return Object
     * @throws BeansException
     *             e
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log("postProcessBeforeInstantiation");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log("postProcessAfterInstantiation");
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
            String beanName) throws BeansException {
        log("postProcessPropertyValues");
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log("postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log("postProcessAfterInitialization");
        return bean;
    }
}