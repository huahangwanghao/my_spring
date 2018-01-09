package com.wanghao.test;

import com.wanghao.ioc.beans.context.ApplicationContext;
import com.wanghao.ioc.beans.context.ClassPathXmlApplicationContext;
import com.wanghao.ioc.beans.test.HelloWorldService;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/29.
 */

public class ApplicationContextTest {
    @Test
    public void test_root() throws  Exception{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-root.xml");
        HelloWorldService helloWorldService= (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

    @Test
    public void test_ioc() throws  Exception{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-ioc.xml");
        HelloWorldService helloWorldService= (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}