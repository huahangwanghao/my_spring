package com.wanghao.ioc;/**
 * Created by Administrator on 2017/12/27.
 */

/**
 * 创建一个Bean的定义和配置
 *
 * @author WangH
 * @create 2017-12-27 13:58
 **/
public class BeanDefinition {
    
    //保存Bean 以及配置信息
    
    private Object bean;
    
    public BeanDefinition(Object bean){
        this.bean=bean;
    }
    
    public Object getBean(){
        return bean;
    }
    
}
