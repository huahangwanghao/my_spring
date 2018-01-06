package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2018/1/6.
 */

import org.aopalliance.aop.Advice;

/**
 * @author WangH
 * @create 2018-01-06 12:16
 **/
public class AspectJExpressPointCutAdvisor implements  PointCutAdvisor {
    
    private AspectJExpressionPointCut pointCut=new AspectJExpressionPointCut();
    
    private Advice advice;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
    
    public void setExpress(String express){
        pointCut.setExpression(express);
    }

    @Override
    public PointCut getPointCut() {
        return pointCut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
