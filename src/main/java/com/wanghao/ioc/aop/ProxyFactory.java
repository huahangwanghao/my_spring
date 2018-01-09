package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2018/1/9.
 */

/**
 * @author WangH
 * @create 2018-01-09 10:48
 **/
public class ProxyFactory extends  AdvisedSupport implements AopProxy {
    @Override
    public Object getProxy() {
        return createAopProxy();
    }
    
    public final AopProxy createAopProxy(){
        return new Cglib2AopProxy(this);
    }
}
