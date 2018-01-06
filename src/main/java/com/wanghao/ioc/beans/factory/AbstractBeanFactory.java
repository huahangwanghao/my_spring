package com.wanghao.ioc.beans.factory;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.BeanDefinition;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建一个抽象的bean工厂
 * @author WangH
 * @create 2017-12-27 14:42
 **/
public abstract class AbstractBeanFactory implements BeanFactory {
    //所有的bean都放在这个属性里面
    private Map<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<String, BeanDefinition>();
    //所有bean 的名字都放在 这个list里面
    private final List<String> beanDefinitionNames=new ArrayList<String>();

    /**
     * 在工厂里面获取Bean对象
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) {
        //在那个map里面通过name获取bean对象的封装对象
        BeanDefinition beanDefinition=beanDefinitionMap.get(name);
        if(beanDefinition == null){
            //如果封装对象都是空的,抛出一个异常
            throw  new IllegalArgumentException("没有bean命名为"+name+"被定义");
        }
        //如果不是空, 获取封装对象里面的真实对象
        Object bean=beanDefinition.getBean();
        if(bean ==null ){
            //如果是空的,进行创建对象
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
