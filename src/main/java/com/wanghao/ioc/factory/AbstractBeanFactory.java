package com.wanghao.ioc.factory;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author WangH
 * @create 2017-12-27 14:42
 **/
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<String, BeanDefinition>();

    @Override
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        Object bean=doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name,beanDefinition);
    }
    
    public abstract  Object doCreateBean(BeanDefinition beanDefinition);
}
