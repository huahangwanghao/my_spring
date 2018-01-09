package com.wanghao.ioc.beans.test;/**
 * Created by Administrator on 2018/1/6.
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 时间拦截器, 判断一个方法执行的时间
 * 记录每个方法的执行时间
 *
 * @author WangH
 * @create 2018-01-06 10:39
 **/
public class TimeInterceptor implements MethodInterceptor {
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        
        long start=System.nanoTime();
        System.out.println(invocation.getMethod());
        System.out.println("Invocation of Method:"+invocation.getMethod().getName()+" start !");
        //这句话才是真正的调用呢.
        Object obj=invocation.proceed();
        System.out.println("Invocation of Method:"+invocation.getMethod().getName()+" end !  take "+ (System.nanoTime()-start)+"纳秒");
        
        return obj;
    }
}
