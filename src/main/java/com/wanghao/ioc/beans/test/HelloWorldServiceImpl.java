package com.wanghao.ioc.beans.test;/**
 * Created by Administrator on 2018/1/6.
 */

/**
 * @author WangH
 * @create 2018-01-06 10:51
 **/
public class HelloWorldServiceImpl implements HelloWorldService {


    private String text;

    private int age;

    private OutputService outputService;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void helloWorld(){
        outputService.output(this.text);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
