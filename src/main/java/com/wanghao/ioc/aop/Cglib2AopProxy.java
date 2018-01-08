package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2018/1/8.
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author WangH
 * @create 2018-01-08 15:02
 **/
public class Cglib2AopProxy extends  AbstractAopProxy {


    public Cglib2AopProxy(AdvisedSupport advised) {
        super(advised);
    }

    @Override
    public Object getProxy() {

        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(advised.getTargetSource().getTargetClass());
        enhancer.setInterfaces(advised.getTargetSource().getInterfaces());
        enhancer.setCallback(new DynamicAdvisedInterceptor(advised));
        
        
        return null;
    }
    
    
    private static class DynamicAdvisedInterceptor implements MethodInterceptor {

        private AdvisedSupport advised;
        
        private MethodInterceptor delegateMethodInterceptor;

        public DynamicAdvisedInterceptor(AdvisedSupport advised) {
            this.advised = advised;
        }

     
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            //TODO 好多东西
            if(advised.getMethodMatcher()==null ){}
            
            
            
            return null;
        }
    }
    
}
