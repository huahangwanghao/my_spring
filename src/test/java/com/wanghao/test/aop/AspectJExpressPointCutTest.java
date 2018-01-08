package com.wanghao.test.aop;/**
 * Created by Administrator on 2018/1/6.
 */

import com.wanghao.ioc.aop.AspectJExpressionPointCut;
import com.wanghao.ioc.beans.test.HelloWorldServiceImpl;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author WangH
 * @create 2018-01-06 14:34
 **/
public class AspectJExpressPointCutTest {

    @Test
    public void textClassFilter() throws  Exception{
        String express="execution( * com1.abc.wanghao.*.*(..))";
        AspectJExpressionPointCut aspectJExpressionPointCut=new AspectJExpressionPointCut();
        aspectJExpressionPointCut.setExpression(express);
        boolean matches=aspectJExpressionPointCut.getClassFilter().matches(HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
        
    }
    
    //下面这个表达式 必须具体到某各类的的具体包名下面
    @Test
    public void testMethodFilter()throws  Exception{
        String express="execution(* com.wanghao.ioc.beans.test.*.*(..))";
        AspectJExpressionPointCut aspectJExpressionPointCut=new AspectJExpressionPointCut();
        aspectJExpressionPointCut.setExpression(express);
        boolean matches=aspectJExpressionPointCut.getMethodMatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"), HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
    
    
    
}
