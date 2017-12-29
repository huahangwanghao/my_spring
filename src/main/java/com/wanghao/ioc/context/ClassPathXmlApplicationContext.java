package com.wanghao.ioc.context;/**
 * Created by Administrator on 2017/12/29.
 */

import com.wanghao.ioc.BeanDefinition;
import com.wanghao.ioc.factory.AbstractBeanFactory;
import com.wanghao.ioc.factory.AutowireCapableBeanFactory;
import com.wanghao.ioc.io.ResourceLoad;
import com.wanghao.ioc.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author WangH
 * @create 2017-12-29 10:25
 **/
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {
    
    private String configLocation;
    

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws  Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }

    public ClassPathXmlApplicationContext(String configLocation) throws  Exception {
        this(new AutowireCapableBeanFactory(),configLocation);
        System.out.println("ClassPathXmlApplicationContext 构造函数"+configLocation);

    }
    
    @Override
    public void refresh()throws  Exception{
        XmlBeanDefinitionReader xmlBeanDefinitionReader=new XmlBeanDefinitionReader(new ResourceLoad());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry:xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }
    }
}
