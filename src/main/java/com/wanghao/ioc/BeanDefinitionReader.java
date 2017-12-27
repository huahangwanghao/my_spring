package com.wanghao.ioc;

/**
 * Created by Administrator on 2017/12/27.
 */
public interface BeanDefinitionReader {
    void loadBeanDefinitions(String location) throws  Exception;
}
