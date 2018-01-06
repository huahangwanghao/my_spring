package com.wanghao.test;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.BeanDefinition;
import com.wanghao.ioc.beans.factory.AutowireCapableBeanFactory;
import com.wanghao.ioc.beans.factory.BeanFactory;
import com.wanghao.ioc.beans.io.ResourceLoad;
import com.wanghao.ioc.beans.test.HelloWorldService;
import com.wanghao.ioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * 创建一个测试类
 *
 * @author WangH
 * @create 2017-12-27 14:09
 **/
public class BeanFactoryTest {
    
    
    @Test
    public void test() throws Exception {
       
        
        
        //1.读取配置文件
        /***
         * 配置文件在创建对象的时候 ResourceLoad 就被new出来啦
         */
        XmlBeanDefinitionReader xmlBeanDefinitionReader=new XmlBeanDefinitionReader(new ResourceLoad());
        /**
         * 加载配置文件
         * 1. 到这一步 对象都创建成功啦.但是里面的属性
         */
        xmlBeanDefinitionReader.loadBeanDefinitions("spring-root.xml");
        
        //2.初始化BeanFactory 并注册bean
        BeanFactory beanFactory=new AutowireCapableBeanFactory();
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry:xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }
        
        beanFactory.preInstantiateSingletons();
        
        //3.获取bean
        HelloWorldService helloWorldService= (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
    
   
    
}
