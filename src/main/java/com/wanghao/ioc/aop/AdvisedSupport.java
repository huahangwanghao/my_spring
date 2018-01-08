package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2017/12/29.
 */

import org.aopalliance.intercept.MethodInterceptor;

/**
 * 这个类包含的 目标对象, 方法拦截器的参数, 
 * 
 * 里面包含了target对象/ targetClass  还有 MethodInterceptor(拦截方法)
 * 
 * 其他的就是简单的set/get方法
 * 
 * @author WangH
 * @create 2017-12-29 14:27
 **/
public class AdvisedSupport {
    
    private TargetSource targetSource;
    
    private MethodInterceptor methodInterceptor;
    
    private MethodMatcher methodMatcher;


    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }
}
