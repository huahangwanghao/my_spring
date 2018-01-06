package com.wanghao.ioc.beans.test;/**
 * Created by Administrator on 2017/12/28.
 */

/**
 * @author WangH
 * @create 2017-12-28 10:55
 **/
public class OutputService {
    private HelloWorldService helloWorldService;
    
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void output(String text){
        System.out.println("outputservice");
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
