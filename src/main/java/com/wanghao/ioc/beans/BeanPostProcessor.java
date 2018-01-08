package com.wanghao.ioc.beans;

/**
 * 
 * 这是BeanFacotry 提供的, 在Bean初始化的过程中,进行扩展的接口, 只要你的Bean实现了BeanPostProcessor,那么Spring在初始化的时候
 * 会优先找到它们,
 * 并且在Bean初始化的过程中, 调用这个接口. 从而实现对BeanFactory核心无侵入的扩展
 * 
 * 
 * Created by Administrator on 2018/1/6.
 */
public interface BeanPostProcessor {
    
    Object postProcessBeforeInittialization(Object bean,String beanName) throws  Exception;
    
    
    Object postProcessAfterInittialization(Object bean,String beanName) throws  Exception;
    
}
