package com.wanghao.ioc;/**
 * Created by Administrator on 2017/12/27.
 */

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean工厂
 *
 * @author WangH
 * @create 2017-12-27 13:57
 **/
public class BeanFactory {

    /***
     * IOC最基本的俩个角色 容器(BeanFactory)和bean本身
     * 这里使用BeanDefinition来封装bean对象, 这样可以保存一些额外的元信息
     * beanDefinitonMap 保存当前的元数据, 里面会很大很大的
     */

    private Map<String,BeanDefinition> beanDefinitonMap=new ConcurrentHashMap<String,BeanDefinition>();
    
    public Object getBean(String name){
        return beanDefinitonMap.get(name).getBean();
    }
    
    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitonMap.put(name,beanDefinition);
    }
}
