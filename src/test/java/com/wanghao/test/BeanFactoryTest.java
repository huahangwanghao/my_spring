package com.wanghao.test;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.BeanDefinition;
import com.wanghao.ioc.factory.AutowireCapableBeanFactory;
import com.wanghao.ioc.factory.BeanFactory;
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
       
        //1.创建BeanFactory
        BeanFactory beanFactory=new AutowireCapableBeanFactory();

        /**
         *2.注入bean
         * BeanDefinition 并不是真正的bean ,而是一个 对于bean对象的封装,
         * BeanDefinition里面有真正的bean的内容,现在是我们传入给Factory class的全类名, 让BeanFactory自己通过反射去创建对象
         * 
         */
        
        BeanDefinition beanDefinition=new BeanDefinition();
        beanDefinition.setBeanClassName("com.wanghao.test.HelloWorldService");
        beanFactory.registerBeanDefinition("helloWorld",beanDefinition);
        
        //3.获取bean
        HelloWorldService helloWorldService= (HelloWorldService) beanFactory.getBean("helloWorld");
        helloWorldService.helloWorld();
    }
    
   
    
}
