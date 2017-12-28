package com.wanghao.ioc;/**
 * Created by Administrator on 2017/12/28.
 */

/**
 * bean之间的引用
 *
 * @author WangH
 * @create 2017-12-28 10:13
 **/
public class BeanReference {
    
    private String name;
    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
