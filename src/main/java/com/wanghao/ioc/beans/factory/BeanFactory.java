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
    /**
     * 通过name 在BeanFactory里面获取对象
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name) throws Exception;
   /* void registerBeanDefinition(String name, BeanDefinition beanDefinition);

    void preInstantiateSingletons();*/
}
