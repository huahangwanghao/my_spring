package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2017/12/29.
 */

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author WangH
 * @create 2017-12-29 14:27
 **/
public class AdvisedSupport {
    
    private TargetSource targetSource;
    
    private MethodInterceptor methodInterceptor;


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
}
