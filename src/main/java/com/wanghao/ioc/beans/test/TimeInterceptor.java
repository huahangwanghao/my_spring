package com.wanghao.ioc.beans.test;/**
 * Created by Administrator on 2018/1/6.
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 时间拦截器, 判断一个方法执行的时间
 * 记录每个方法的执行时间
 *
 * @author WangH
 * @create 2018-01-06 10:39
 **/
public class TimeInterceptor implements MethodInterceptor {
    Logger log= LoggerFactory.getLogger(TimeInterceptor.class);
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        
        long start=System.nanoTime();
        log.info("Invocation of Method:"+invocation.getMethod().getName()+" start !");
        //这句话才是真正的调用呢.
        Object obj=invocation.proceed();
        log.info("Invocation of Method:"+invocation.getMethod().getName()+" end !  take "+ (System.nanoTime()-start)+"纳秒");
        
        return obj;
    }
}
