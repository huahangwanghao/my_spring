package com.wanghao.ioc.factory;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.BeanDefinition;

/**
 * @author WangH
 * @create 2017-12-27 14:49
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
            Object obj=beanDefinition.getBeanClass().newInstance();
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
