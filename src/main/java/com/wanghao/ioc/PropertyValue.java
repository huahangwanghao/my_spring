package com.wanghao.ioc;/**
 * Created by Administrator on 2017/12/27.
 */

/**
 * 对于bean的属性注入
 * 对于属性而言,无非就是 名字和值 这是抽象出来的内容
 *
 * @author WangH
 * @create 2017-12-27 15:10
 **/
public class PropertyValue {
    
    private final String name;
    
    private final Object value;
    
    public PropertyValue(String name,Object value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
