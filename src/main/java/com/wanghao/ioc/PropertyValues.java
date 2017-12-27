package com.wanghao.ioc;/**
 * Created by Administrator on 2017/12/27.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 包装一个对象的所有属性PropertyValue
 * 这样可以多一些封装,而不是单纯的使用List的好处
 * 
 * 然后把这个属性赋值给beanDefinition, 相当于我能够让BeanDefinition里面的Object bean 能够有多个对象
 * 
 * 
 *
 * @author WangH
 * @create 2017-12-27 15:10
 **/
public class PropertyValues {
   
    private final List<PropertyValue> propertyValueList=new ArrayList<PropertyValue>();
   
    public PropertyValues(){
        
    }
    
    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }
    
    public List<PropertyValue> getPropertyValueLists(){
        return this.propertyValueList;
    }
    
}
