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
        
        private org.aopalliance.intercept.MethodInterceptor delegateMethodInterceptor;

        public DynamicAdvisedInterceptor(AdvisedSupport advised) {
            this.advised = advised;
            this.delegateMethodInterceptor=advised.getMethodInterceptor();
        }

     
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            //TODO 好多东西
            if(advised.getMethodMatcher()==null
               || advised.getMethodMatcher().matches(method,advised.getTargetSource().getTargetClass())){
                return delegateMethodInterceptor.invoke(new CglibMethodInvocation(advised.getTargetSource().getTarget(),method,objects,methodProxy));
            }
            
            
            
            return new CglibMethodInvocation(advised.getTargetSource().getTarget(),method,objects,methodProxy).proceed();
        }
    }
    
    private static class CglibMethodInvocation extends  ReflectiveMethodInvocation{

        private final MethodProxy methodProxy;
       
        public CglibMethodInvocation(Object target, Method method, Object[] args,MethodProxy methodProxy) {
            super(target, method, args);
            this.methodProxy=methodProxy;
        }

        @Override
        public Object proceed() throws Throwable {
            return this.methodProxy.invoke(this.target,this.args);
        }
    }
    
}
