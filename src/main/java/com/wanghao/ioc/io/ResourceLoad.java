package com.wanghao.ioc.io;/**
 * Created by Administrator on 2017/12/27.
 */

import java.net.URL;

/**
 * @author WangH
 * @create 2017-12-27 17:14
 **/
public class ResourceLoad {
    
    public Resource getResource(String location){

        URL resource=this.getClass().getClassLoader().getResource(location);
        
        return new URLResource(resource);
    }
    
}
