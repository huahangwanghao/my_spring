package com.wanghao.ioc;/**
 * Created by Administrator on 2017/12/27.
 */

/**
 * 创建一个Bean的定义和配置
 *
 * @author WangH
 * @create 2017-12-27 13:58
 **/
public class BeanDefinition {
    
    //保存Bean 以及配置信息
    
    private Object bean;
    
    private Class beanClass;
    
    private String beanClassName;
    
    public BeanDefinition(){}

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        
        try {
            this.beanClass=Class.forName(beanClassName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        
    }
}
