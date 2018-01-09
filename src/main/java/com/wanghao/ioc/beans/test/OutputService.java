package com.wanghao.ioc.beans.test;/**
 * Created by Administrator on 2017/12/28.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WangH
 * @create 2017-12-28 10:55
 **/
public class OutputService {
    Logger log= LoggerFactory.getLogger(OutputService.class);
    private HelloWorldService helloWorldService;
    
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void output(String text){
        log.info("outputservice");
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
