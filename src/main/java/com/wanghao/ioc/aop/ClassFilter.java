package com.wanghao.ioc.aop;

/**
 * 对于类的匹配
 * Created by Administrator on 2018/1/6.
 */
public interface ClassFilter {
    boolean matches(Class targetClass);
}
