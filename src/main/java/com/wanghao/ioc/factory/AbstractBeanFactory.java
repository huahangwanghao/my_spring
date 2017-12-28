package com.wanghao.ioc.factory;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author WangH
 * @create 2017-12-27 14:42
 **/
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<String, BeanDefinition>();
    
    private final List<String> beanDefinitionNames=new ArrayList<String>(); 

    @Override
    public Object getBean(String name) {
        
        BeanDefinition beanDefinition=beanDefinitionMap.get(name);
        if(beanDefinition == null){
            throw  new IllegalArgumentException("没有bean命名为"+name+"被定义");
        }
        Object bean=beanDefinition.getBean();
        if(bean ==null ){
            bean=doCreateBean(beanDefinition);
        }
        return bean;
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        /*Object bean=doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        */
        beanDefinitionMap.put(name,beanDefinition);
        beanDefinitionNames.add(name);
    }
    
    public void preInstantiateSingletons() {
        for(Iterator it=this.beanDefinitionNames.iterator();it.hasNext();){
            String beanName= (String) it.next();
            getBean(beanName);
        }
    }
    
    public abstract  Object doCreateBean(BeanDefinition beanDefinition);
}
