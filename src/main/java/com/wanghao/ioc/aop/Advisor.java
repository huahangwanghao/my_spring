package com.wanghao.ioc.aop;

import org.aopalliance.aop.Advice;

/**Advisor:顾问
 * Advice:建议
 * Created by Administrator on 2018/1/6.
 */
public interface Advisor  {
    //从顾问这里得到建议....逗比
    Advice getAdvice();
    
}
