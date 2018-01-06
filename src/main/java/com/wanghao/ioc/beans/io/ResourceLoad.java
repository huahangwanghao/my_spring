package com.wanghao.ioc.beans.io;/**
 * Created by Administrator on 2017/12/27.
 */

import java.net.URL;

/**
 * @author WangH
 * @create 2017-12-27 17:14
 * 
 * 资源加载器, 通过传递进来一个连接的地址, 返回URLResource
 * 
 **/
public class ResourceLoad {
    
    //通过
    public Resource getResource(String location){

        URL resource=this.getClass().getClassLoader().getResource(location);
        
        return new URLResource(resource);
    }
    
}
