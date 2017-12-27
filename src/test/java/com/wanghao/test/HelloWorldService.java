package com.wanghao.test;

/**
 * @author yihua.huang@dianping.com
 */
public class HelloWorldService {

    private String text;
    
    private int age;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void helloWorld(){
        System.out.println(this.text+"---->"+this.age); 
    }

    public void setAge(int age) {
        this.age = age;
    }
}
