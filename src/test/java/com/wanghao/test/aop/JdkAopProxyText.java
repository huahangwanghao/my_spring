package com.wanghao.test.aop;/**
 * Created by Administrator on 2018/1/6.
 */

import com.wanghao.ioc.aop.AdvisedSupport;
import com.wanghao.ioc.aop.JdkDynamicPopProxy;
import com.wanghao.ioc.aop.TargetSource;
import com.wanghao.ioc.beans.context.ApplicationContext;
import com.wanghao.ioc.beans.context.ClassPathXmlApplicationContext;
import com.wanghao.ioc.beans.test.HelloWorldService;
import com.wanghao.ioc.beans.test.TimeInterceptor;
import org.junit.Test;

/**
 * @author WangH
 * @create 2018-01-06 10:38
 **/
public class JdkAopProxyText {
    
    @Test
    public  void testInterceptor()throws  Exception{
        ApplicationContext app=new ClassPathXmlApplicationContext("spring-root.xml");
        HelloWorldService helloWorldService= (HelloWorldService) app.getBean("helloWorldService");
        helloWorldService.helloWorld();
        System.out.println("----------------with AOP-------------|");


        //创建一个代理的支持类
        AdvisedSupport advisedSupport=new AdvisedSupport();
        //TargetSource 是被代理对象的一种封装
        TargetSource targetSource=new TargetSource(null,null,HelloWorldService.class);
        //让代理类 里面有了被代理对象
        advisedSupport.setTargetSource(targetSource);
        
        //2.设置拦截器
        TimeInterceptor timeInterceptor=new TimeInterceptor();
        //  2.1设置方法拦截器
        advisedSupport.setMethodInterceptor(timeInterceptor);
        
        
        //3创建代理
        JdkDynamicPopProxy jdkDynamicPopProxy=new JdkDynamicPopProxy(advisedSupport);
        HelloWorldService helloWorldService1= (HelloWorldService) jdkDynamicPopProxy.getProxy();
        helloWorldService1.helloWorld();
        
        
        
    }
    
}
