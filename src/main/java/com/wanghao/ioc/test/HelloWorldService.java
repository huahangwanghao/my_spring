package com.wanghao.ioc.test;/**
 * Created by Administrator on 2017/12/28.
 */

/**
 * @author WangH
 * @create 2017-12-28 10:56
 **/
public class HelloWorldService {

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
