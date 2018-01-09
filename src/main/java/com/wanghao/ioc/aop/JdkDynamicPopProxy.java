package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2017/12/29.
 */

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK的俩个动态代理
 * 里面有了AdvisedSupport , 就相当于有了被代理的对象, 和方法拦截器 都有啦.
 * 
 *
 * @author WangH
 * @create 2017-12-29 14:24
 **/
public class JdkDynamicPopProxy implements AopProxy,InvocationHandler {
    
    private AdvisedSupport advisedSupport;

    public JdkDynamicPopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    
    @Override
    public Object getProxy() {
        /**
         * ClassLoader loader: 获取类加载器, 默认情况下都是这样写
         * Class<?>[] interfaces:目标对象实现的接口的类型,使用泛型方式确认类型,简单理解目标对象的类型, 因为是基于接口的, 如果不是基于接口 会报错 not a interface
         * InvocationHandler h: 这里传递的是this   会调用下面的 invoke 方法
         */
        return Proxy.newProxyInstance(getClass().getClassLoader(),advisedSupport.getTargetSource().getInterfaces(),this);
    }

   
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //先获取到方法拦截器, 这个其实获取到的是timeInterceptor
        MethodInterceptor methodInterceptor=advisedSupport.getMethodInterceptor();
        /***
         *Object invoke(MethodInvocation invocation) 
         * 
         * 是调用目标对象的 method 方法, 参数是 args
         */
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(),method,args));
    }
}
