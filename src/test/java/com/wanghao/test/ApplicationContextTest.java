package com.wanghao.test;

import com.wanghao.ioc.context.ApplicationContext;
import com.wanghao.ioc.context.ClassPathXmlApplicationContext;
import com.wanghao.ioc.test.HelloWorldService;
import org.junit.Test;

/**
 * Created by Administrator on 2017/12/29.
 */

public class ApplicationContextTest {
    @Test
    public void test() throws  Exception{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-root.xml");
        HelloWorldService helloWorldService= (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}