package com.wanghao.ioc.beans.factory;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.BeanDefinition;
import com.wanghao.ioc.BeanReference;
import com.wanghao.ioc.PropertyValue;
import com.wanghao.ioc.aop.BeanFactoryAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author WangH
 * @create 2017-12-27 14:49
 * 
 * 这是一个BeanFactory, bean的工厂 继承抽象类 AbstractBeanFactory  实现接口 BeanFactory
 * 
 * 
 **/
public class AutowireCapableBeanFactory extends AbstractBeanFactory{

    Logger logger= LoggerFactory.getLogger(AutowireCapableBeanFactory.class);
    
    

    /**
     * 
     * @param bean  给他添加属性
     * @param beanDefinition
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Override
    protected  void applyPropertyValues(Object bean,BeanDefinition beanDefinition) throws Exception {
        //如果这个bean 是  BeanFactoryAware的子类 其实这里就是AspectJAwareAdvisorAutoProxyCreator
        //其实也就是xml里面的 autoProxyCreator
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware)bean).setBeanFactory(this);
        }
        
        for(PropertyValue pv:beanDefinition.getPropertyValues().getPropertyValueLists()){
            
            Object value=pv.getValue();
           if(value instanceof BeanReference){
                BeanReference beanReference= (BeanReference) value;
                //通过name获取到对象的方法
                value=getBean(beanReference.getName());
            }
            
            try {
                String setName="set"+pv.getName().substring(0,1).toUpperCase()+pv.getName().substring(1);
                Method method=bean.getClass().getDeclaredMethod(setName,value.getClass());
                method.setAccessible(true);
                method.invoke(bean,value);
                logger.info("setMethod Name is:"+setName);

            }catch (Exception e){
                //通过那个bean这个对象,能够得到这个对象的声明式属性, 通过属性名, 然后得到这个属性, 就是一个Field
                Field declaredField=bean.getClass().getDeclaredField(pv.getName());
                //对于这个Field 设置可以访问
                declaredField.setAccessible(true);
                declaredField.set(bean,value);
            }
           
          
            
        }
    }
}
