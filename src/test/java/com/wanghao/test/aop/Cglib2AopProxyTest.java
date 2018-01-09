package com.wanghao.test.aop;/**
 * Created by Administrator on 2018/1/9.
 */

import com.wanghao.ioc.aop.AdvisedSupport;
import com.wanghao.ioc.aop.Cglib2AopProxy;
import com.wanghao.ioc.aop.TargetSource;
import com.wanghao.ioc.beans.context.ApplicationContext;
import com.wanghao.ioc.beans.context.ClassPathXmlApplicationContext;
import com.wanghao.ioc.beans.test.HelloWorldService;
import com.wanghao.ioc.beans.test.HelloWorldServiceImpl;
import com.wanghao.ioc.beans.test.TimeInterceptor;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WangH
 * @create 2018-01-09 11:07
 **/
public class Cglib2AopProxyTest {
    Logger logger= LoggerFactory.getLogger(Cglib2AopProxyTest.class);
    
    @Test
    public void testInterceptor() throws  Exception{

        logger.info("test");
        ApplicationContext application=new ClassPathXmlApplicationContext("spring-root.xml");
        HelloWorldService helloWorldService= (HelloWorldService) application.getBean("helloWorldService");
        helloWorldService.helloWorld();
        
        //--------------------------------------------------------
        AdvisedSupport advisedSupport=new AdvisedSupport();
        TargetSource targetSource=new TargetSource(helloWorldService,HelloWorldServiceImpl.class,HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        TimeInterceptor timeInterceptor=new TimeInterceptor();
        advisedSupport.setMethodInterceptor(timeInterceptor);


        Cglib2AopProxy cglib2AopProxy=new Cglib2AopProxy(advisedSupport);
        HelloWorldService helloWorldService1 = (HelloWorldService) cglib2AopProxy.getProxy();
        helloWorldService1.helloWorld();
        
        
        
        
        
        
        
        
    }
    
}
