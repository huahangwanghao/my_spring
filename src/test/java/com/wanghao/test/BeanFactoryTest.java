package com.wanghao.test;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.BeanDefinition;
import com.wanghao.ioc.BeanFactory;
import org.junit.Test;

/**
 * 创建一个测试类
 *
 * @author WangH
 * @create 2017-12-27 14:09
 **/
public class BeanFactoryTest {
    
    
    @Test
    public void test(){
        //1.初始化BeanFactory
        BeanFactory beanFactory=new BeanFactory();

        //2.注入bean
        BeanDefinition beanDefinition=new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService",beanDefinition);
        
        //3.获取bean
       HelloWorldService helloWorldService= (HelloWorldService) beanFactory.getBean("helloWorldService");
       helloWorldService.helloWorld();
    }
    
   
    
}
