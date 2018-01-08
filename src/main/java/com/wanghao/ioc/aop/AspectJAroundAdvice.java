package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2018/1/8.
 */

import com.wanghao.ioc.beans.factory.BeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author WangH
 * @create 2018-01-08 14:37
 **/
public class AspectJAroundAdvice implements MethodInterceptor,Advice {
    
    private BeanFactory beanFactory;
    
    private Method aspectJAdviceMethod;
    
    private String aspectInstanceName;

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Method getAspectJAdviceMethod() {
        return aspectJAdviceMethod;
    }

    public void setAspectJAdviceMethod(Method aspectJAdviceMethod) {
        this.aspectJAdviceMethod = aspectJAdviceMethod;
    }

    public String getAspectInstanceName() {
        return aspectInstanceName;
    }

    public void setAspectInstanceName(String aspectInstanceName) {
        this.aspectInstanceName = aspectInstanceName;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("执行前时间"+new Date());
        Thread.sleep(2000);
        System.out.println("执行后时间"+new Date());
    }
}
