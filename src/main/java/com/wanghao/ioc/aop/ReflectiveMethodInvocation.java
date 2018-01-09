package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2017/12/29.
 */

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * 
 * 这个类实现方法调用接口
 * 主要的作用就是对于方法的封装
 * 包含  目标类, 方法, 参数
 * 主要的作用是为了InvocationHandler的实现类中的 Object invoke(MethodInvocation invocation)   提供材料
 * @author WangH
 * @create 2017-12-29 14:29
 **/
public class ReflectiveMethodInvocation implements MethodInvocation {
    
    
    public Object target;
    
    public Method method;
    
    public Object[] args;

    /***
     * 把目标类, 方法对象, 参数都传递过来啦
     * @param target
     * @param method
     * @param args
     */
    public ReflectiveMethodInvocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    /**
     * Gets the method being called.
     * <p>
     * <p>This method is a frienly implementation of the {@link
     *
     * @return the method being called.
     */
    @Override
    public Method getMethod() {
        return method;
    }

    /**
     * Get the arguments as an array object.
     * It is possible to change element values within this
     * array to change the arguments.
     *
     * @return the argument of the invocation
     */
    @Override
    public Object[] getArguments() {
        return args;
    }

    /**
     * 通过反射去调用方法
     * Proceeds to the next interceptor in the chain.
     * <p>
     * <p>The implementation and the semantics of this method depends
     * on the actual joinpoint type (see the children interfaces).
     *
     * @return see the children interfaces' proceed definition.
     * @throws Throwable if the joinpoint throws an exception.
     */
    @Override
    public Object proceed() throws Throwable {
       return method.invoke(target,args);
    }

    /**
     * Returns the object that holds the current joinpoint's static
     * part.
     * <p>
     * <p>For instance, the target object for an invocation.
     *
     * @return the object (can be null if the accessible object is
     * static).
     */
    @Override
    public Object getThis() {
        return target;
    }

   
    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
