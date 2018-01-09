package com.wanghao.ioc.beans.factory;

/**
 * Created by Administrator on 2017/12/27.
 * 
 * 首先为了扩展性, 我们把BeanFactory 作为一个接口
 * 我们希望容器来 管理bean的创建, 于是我们把bean的初始化放入了beanFactory
 * 
 * 
 */
public interface BeanFactory {
    Object getBean(String name);
   /* void registerBeanDefinition(String name, BeanDefinition beanDefinition);

    void preInstantiateSingletons();*/
}
