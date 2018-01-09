package com.wanghao.ioc.beans.context;/**
 * Created by Administrator on 2017/12/29.
 */

import com.wanghao.ioc.BeanDefinition;
import com.wanghao.ioc.beans.factory.AbstractBeanFactory;
import com.wanghao.ioc.beans.io.ResourceLoad;
import com.wanghao.ioc.beans.xml.XmlBeanDefinitionReader;
import com.wanghao.ioc.beans.factory.AutowireCapableBeanFactory;

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
        super.refresh();
    }

    public ClassPathXmlApplicationContext(String configLocation) throws  Exception {
        this(new AutowireCapableBeanFactory(),configLocation);

    }
    
  

    @Override
    protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader=new XmlBeanDefinitionReader(new ResourceLoad());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for(Map.Entry<String,BeanDefinition> beanDefinitionEntry:xmlBeanDefinitionReader.getRegistry().entrySet()){
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(),beanDefinitionEntry.getValue());
        }
    }
}
