package com.wanghao.ioc.aop;

import com.wanghao.ioc.beans.factory.BeanFactory;

/**
 * Created by Administrator on 2018/1/6.
 */
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory)throws Exception;
}
