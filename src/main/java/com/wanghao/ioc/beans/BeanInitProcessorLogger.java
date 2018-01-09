package com.wanghao.ioc.beans;/**
 * Created by Administrator on 2018/1/9.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WangH
 * @create 2018-01-09 13:40
 **/
public class BeanInitProcessorLogger implements  BeanPostProcessor {

    Logger logger= LoggerFactory.getLogger(BeanInitProcessorLogger.class);
    
    @Override
    public Object postProcessBeforeInittialization(Object bean, String beanName) throws Exception {
        logger.info("postProcessBeforeInittialization   "+beanName+"   start");
        return bean;
    }

    @Override
    public Object postProcessAfterInittialization(Object bean, String beanName) throws Exception {
        logger.info("postProcessAfterInittialization    "+beanName+"   end");
        return bean;
    }
}
