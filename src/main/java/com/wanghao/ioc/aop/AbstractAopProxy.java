package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2018/1/8.
 */

/**
 * @author WangH
 * @create 2018-01-08 14:35
 **/
public abstract class AbstractAopProxy implements AopProxy {
    
    protected  AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
