package com.wanghao.ioc.beans.context;/**
 * Created by Administrator on 2017/12/29.
 */

import com.wanghao.ioc.BeanDefinition;
import com.wanghao.ioc.beans.factory.AbstractBeanFactory;

/**
 * @author WangH
 * @create 2017-12-29 10:22
 **/
public class AbstractApplicationContext implements ApplicationContext {
    
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        System.out.println("AbstractApplicationContext 构造函数"+beanFactory);
        
        this.beanFactory = beanFactory;
    }
    
    public void refresh() throws  Exception{
        
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        
    }

    @Override
    public void preInstantiateSingletons() {

    }


}
