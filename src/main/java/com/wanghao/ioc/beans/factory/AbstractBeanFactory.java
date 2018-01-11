package com.wanghao.ioc.beans.factory;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.BeanDefinition;
import com.wanghao.ioc.beans.BeanPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 创建一个抽象的bean工厂
 * @author WangH
 * @create 2017-12-27 14:42
 **/
public abstract class AbstractBeanFactory implements BeanFactory {
    Logger logger= LoggerFactory.getLogger(AbstractBeanFactory.class);
    //所有的bean都放在这个属性里面
    private Map<String,BeanDefinition> beanDefinitionMap=new ConcurrentHashMap<String, BeanDefinition>();
    //所有bean 的名字都放在 这个list里面
    private final List<String> beanDefinitionNames=new ArrayList<String>();
    
    private List<BeanPostProcessor> beanPostProcessors=new ArrayList<BeanPostProcessor>();

    /**
     * 在工厂里面获取Bean对象
     * @param name
     * @return
     */
    @Override
    public Object getBean(String name) throws Exception {
        logger.info("getBean 传递进来的name是 : "+name);
        //在那个map里面通过name获取bean对象的封装对象
        BeanDefinition beanDefinition=beanDefinitionMap.get(name);
        if(beanDefinition == null){
            //如果封装对象都是空的,抛出一个异常
            throw  new IllegalArgumentException("没有bean命名为"+name+"被定义");
        }
        //如果不是空, 获取封装对象里面的真实对象
        Object bean=beanDefinition.getBean();
        if(bean ==null ){
            //如果是空的,进行创建对象
            bean=doCreateBean(beanDefinition);
            bean=initializeBean(bean,name);
            beanDefinition.setBean(bean);
        }
        logger.info("getBean 返回的bean是 : "+bean);
        return bean;
    }


    protected  Object initializeBean(Object bean,String name) throws Exception {
        for (BeanPostProcessor beanPostProcessor:beanPostProcessors){
            bean=beanPostProcessor.postProcessBeforeInittialization(bean,name);
        }
        //TODO call init method
        for (BeanPostProcessor beanPostProcessor:beanPostProcessors){
            bean=beanPostProcessor.postProcessAfterInittialization(bean,name);
        }

        return bean;
    }


    /***
     * 通过反射创建对象.
     * @param beanDefinition
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    protected  Object createBeanInstance(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }
    
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name,beanDefinition);
        beanDefinitionNames.add(name);
    }

    /**
     * 可以理解为单例模式吗??
     * @throws Exception
     */
    public void preInstantiateSingletons() throws Exception {
        for(Iterator it=this.beanDefinitionNames.iterator();it.hasNext();){
            String beanName= (String) it.next();
            getBean(beanName);
        }
    }

    /**
     * 通过beanDefinition 得到里面对象的bean对象
     * @param beanDefinition
     * @return
     */
    public Object doCreateBean(BeanDefinition beanDefinition) {


        try {
            /**
             * 这个在test里面已经先设置了有一个setBeanClass的操作啦.
             * setBeanClassName("com.wanghao.test.HelloWorldService");
             * 然后在BeanDefinition里面的setBeanClassName 里面
             * this.beanClass=Class.forName(beanClassName); 顺路把beanClass也设置成功啦. 所以下面就可以获取到BeanClass
             */
            Object bean=createBeanInstance(beanDefinition);
            beanDefinition.setBean(bean);
            applyPropertyValues(bean,beanDefinition);
            return bean;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 对于Bean的属性赋值, 所有的值都在BeanDefinition里面.
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected abstract void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws  Exception;


    /**
     * 通过读取配置文件
     * ,对于beanPostProcessors里面添加BeanPostProcessor
     * @param beanPostProcessor
     * @throws Exception
     */
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor)throws  Exception{
        this.beanPostProcessors.add(beanPostProcessor);
    }

    /**
     * 通过Class 获取Bean的list
     * 对于List beanDefinitionNames 里面所有的Name进行遍历,如果 type是它们的父类,或者相同,
     * 就把所有的对象都返回回去.
     * @param type
     * @return
     * @throws Exception
     */
    public List getBeansForType(Class type)throws  Exception{
        
        List beans=new ArrayList();
        for(String beanDefinitonName:beanDefinitionNames){
            //type.isAssignableFrom Class1.isAssignableFrom(Class2)    用于判断 Class1 和Class2 是否相同,或者Class2是否是Class1另一个类的子类或者接口
            if(type.isAssignableFrom(beanDefinitionMap.get(beanDefinitonName).getBeanClass())){
                beans.add(getBean(beanDefinitonName));
            }
        }
        
        return beans;
    }
    
   
    



    
}
