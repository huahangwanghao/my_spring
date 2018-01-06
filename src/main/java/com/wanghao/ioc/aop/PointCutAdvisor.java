package com.wanghao.ioc.aop;

/**
 * Created by Administrator on 2018/1/6.
 */
public interface PointCutAdvisor extends Advisor {
    
    PointCut getPointCut();
    
}
