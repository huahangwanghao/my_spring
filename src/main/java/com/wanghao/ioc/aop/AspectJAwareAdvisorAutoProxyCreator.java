package com.wanghao.ioc.aop;/**
 * Created by Administrator on 2018/1/6.
 */

import com.wanghao.ioc.beans.BeanPostProcessor;
import com.wanghao.ioc.beans.factory.AbstractBeanFactory;
import com.wanghao.ioc.beans.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

/**
 * @author WangH
 * @create 2018-01-06 15:34
 **/
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor,BeanFactoryAware {
    //注入一个beanFactory
    private AbstractBeanFactory beanFactory;
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.beanFactory= (AbstractBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInittialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInittialization(Object bean, String beanName) throws Exception {
        
        if(bean instanceof  AspectJExpressionPointCut){
            return bean;
        }
        if(bean instanceof MethodInterceptor){
            return bean;
        }
        
        List<AspectJExpressPointCutAdvisor> advisors=beanFactory.getBeansForType(AspectJExpressPointCutAdvisor.class);
        for(AspectJExpressPointCutAdvisor advisor:advisors){
            if(advisor.getPointCut().getClassFilter().matches(bean.getClass())){
                AdvisedSupport advisedSupport=new AdvisedSupport();
                //TODO 没有搞明白
                advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                advisedSupport.setMethodMatcher(advisor.getPointCut().getMethodMatcher());
                
                TargetSource targetSource=new TargetSource(bean,bean.getClass().getInterfaces());
                advisedSupport.setTargetSource(targetSource);
                return new JdkDynamicPopProxy(advisedSupport).getProxy();
            }
        }
        
        return bean;
    }
}
