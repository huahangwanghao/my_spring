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
        registerBeanPostProcessors(beanFactory);
        onRefresh();
    }

    /**
     * 就是把所有的对象都放到BeanFactory里面的beanDefinitionMap,beanDefinitionNames
     * 按照配置文件都增加好啦./
     * @param beanFactory
     * @throws Exception
     */
    protected  abstract  void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;


    /**
     * 
     * @param beanFactory
     * @throws Exception
     */
    protected  void registerBeanPostProcessors(AbstractBeanFactory beanFactory)throws Exception{
        /**
         *第一次还真有一个AspectJAwareAdvisorAutoProxyCreator,也是在spring的配置文件里面配置好的 
         */
        List beanPostProcessors=beanFactory.getBeansForType(BeanPostProcessor.class); 
        for(Object beanPostProcessor:beanPostProcessors){
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }
    
    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    protected  void onRefresh() throws  Exception{
        beanFactory.preInstantiateSingletons();
    }
    
    
   


}
