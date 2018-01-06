package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2017/12/29.
 */

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @author WangH
 * @create 2017-12-29 14:29
 **/
public class ReflectiveMethodInvocation implements MethodInvocation {
    
    
    private Object target;
    
    private Method method;
    
    private Object[] args;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    /**
     * Gets the method being called.
     * <p>
     * <p>This method is a frienly implementation of the {@link
     * Joinpoint#getStaticPart()} method (same result).
     *
     * @return the method being called.
     */
    @Override
    public Method getMethod() {
        return null;
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
        return new Object[0];
    }

    /**
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
        return null;
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
        return null;
    }

    /**
     * Returns the static part of this joinpoint.
     * <p>
     * <p>The static part is an accessible object on which a chain of
     * interceptors are installed.
     */
    @Override
    public AccessibleObject getStaticPart() {
        return null;
    }
}
