package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2017/12/29.
 */

/**
 * 被代理的对象的一种包装
 * 里面包含了 target对象 和 targetClass
 * @author WangH
 * @create 2017-12-29 14:27
 **/
public class TargetSource {

    private Class<?> targetClass;
    
    private Class<?> [] interfaces;
    
    private Object target;

    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(Class<?>[] interfaces) {
        this.interfaces = interfaces;
    }


    public Object getTarget() {
        return target;
    }
}
