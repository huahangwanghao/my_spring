package com.wanghao.ioc.factory;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.BeanDefinition;
import com.wanghao.ioc.BeanReference;
import com.wanghao.ioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * @author WangH
 * @create 2017-12-27 14:49
 * 
 * 这是一个BeanFactory, bean的工厂 继承抽象类 AbstractBeanFactory  实现接口 BeanFactory
 * 
 * 
 **/
public class AutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    public Object doCreateBean(BeanDefinition beanDefinition) {


        try {
            /**
             * 这个在test里面已经先设置了有一个setBeanClass的操作啦.
             * setBeanClassName("com.wanghao.test.HelloWorldService");
             * 然后在BeanDefinition里面的setBeanClassName 里面
             * this.beanClass=Class.forName(beanClassName); 顺路把beanClass也设置成功啦. 所以下面就可以获取到BeanClass
             */
            Object bean=createBeanInstance(beanDefinition);
            beanDefinition.setBean(bean);
            applyPropertyValues(bean,beanDefinition);
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    protected  Object createBeanInstance(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     * 
     * @param bean  给他添加属性
     * @param beanDefinition
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    protected  void applyPropertyValues(Object bean,BeanDefinition beanDefinition) throws NoSuchFieldException, IllegalAccessException {
        
        for(PropertyValue pv:beanDefinition.getPropertyValues().getPropertyValueLists()){
            //通过那个bean这个对象,能够得到这个对象的声明式属性, 通过属性名, 然后得到这个属性, 就是一个Field
            Field declaredField=bean.getClass().getDeclaredField(pv.getName());
            //对于这个Field 设置可以访问
            declaredField.setAccessible(true);       
            Object value=pv.getValue();
            if(value instanceof BeanReference){
                BeanReference beanReference= (BeanReference) value;
                //通过name获取到对象的方法
                value=getBean(beanReference.getName());
            }
            declaredField.set(bean,value);    
            
        }
    }
}
