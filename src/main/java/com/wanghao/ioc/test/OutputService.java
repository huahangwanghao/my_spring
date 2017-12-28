package com.wanghao.ioc.test;/**
 * Created by Administrator on 2017/12/28.
 */

/**
 * @author WangH
 * @create 2017-12-28 10:55
 **/
public class OutputService {
    private HelloWorldService helloWorldService;

    public void output(String text){
        System.out.println("outputservice");
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
