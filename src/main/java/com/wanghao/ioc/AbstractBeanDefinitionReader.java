package com.wanghao.ioc;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.beans.io.ResourceLoad;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象类去实现BeanDefinition接口
 *
 * @author WangH
 * @create 2017-12-27 17:10
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    
    
    private Map<String,BeanDefinition> registry;
    
    private ResourceLoad resourceLoad;
    
    public AbstractBeanDefinitionReader(ResourceLoad resourceLoad){
        this.registry=new HashMap<String, BeanDefinition>();
        this.resourceLoad=resourceLoad;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoad getResourceLoad() {
        return resourceLoad;
    }
}
