package com.wanghao.ioc.aop;

import java.lang.reflect.Method;

/**
 * 对于方法的匹配
 * Created by Administrator on 2018/1/6.
 */
public interface MethodMatcher {
    
    boolean matches(Method method,Class targetClass);
    
}
