package com.wanghao.ioc.beans.context;/**
 * Created by Administrator on 2017/12/29.
 */

import com.wanghao.ioc.beans.BeanPostProcessor;
import com.wanghao.ioc.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * @author WangH
 * @create 2017-12-29 10:22
 **/
public abstract class AbstractApplicationContext implements ApplicationContext {
    
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
    
    public void refresh() throws  Exception{
        loadBeanDefinitions(beanFactory);
    }
    
    
    protected  abstract  void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;
    

    protected  void registerBeanPostProcessors(AbstractBeanFactory beanFactory)throws Exception{
        List beanPostProcessors=beanFactory.getBeansForType(BeanPostProcessor.class); 
        for(Object beanPostProcessor:beanPostProcessors){
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }
    
    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }

    protected  void onRefresh() throws  Exception{
        beanFactory.preInstantiateSingletons();
    }
    
    
   


}
