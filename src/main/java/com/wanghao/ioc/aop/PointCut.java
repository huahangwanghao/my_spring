package com.wanghao.ioc.aop;

/**
 * 这相当于是对于类名匹配和方法匹配的整合
 * Created by Administrator on 2018/1/6.
 */
public interface PointCut {
    
    ClassFilter getClassFilter();
    MethodMatcher getMethodMatcher();
    
}
