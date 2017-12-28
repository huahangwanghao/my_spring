package com.wanghao.ioc.xml;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.AbstractBeanDefinitionReader;
import com.wanghao.ioc.BeanDefinition;
import com.wanghao.ioc.BeanReference;
import com.wanghao.ioc.PropertyValue;
import com.wanghao.ioc.io.ResourceLoad;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author WangH
 * @create 2017-12-27 17:24
 **/
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoad resourceLoad) {
        super(resourceLoad);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        //得到那个spring_root.xml的输入流啦.
        InputStream inputStream=getResourceLoad().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    /**
     * 加载beanDefination
     * 对于配置文件进行解析
     * @param inputStream
     */
    private void doLoadBeanDefinitions(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder=factory.newDocumentBuilder();
        //通过inputStream 然后加上Document工具 得到一个Document对象
        Document document= documentBuilder.parse(inputStream);
        //对于Document对象进行解析
        registerBeanDefinitions(document);
        inputStream.close();
    }

    /**
     * 解析bean的xml文件
     * @param document
     */
    private void registerBeanDefinitions(Document document) {
      //把document元素转换为Element对象啦  
      Element root=  document.getDocumentElement();
      parseBeanDefinitions(root);
    }

    /**
     * 解析dom文档
     * @param root
     */
    private void parseBeanDefinitions(Element root) {
        //获取下面所有的子节点
        NodeList nodeList=root.getChildNodes();
        for(int i=0;i<nodeList.getLength();i++){
            Node node=nodeList.item(i);
            if(node instanceof  Element){
                Element element = (Element) node;
                processBeanDefinition(element);
            }
        }
        
    }

    /**
     * 解析里面的元素
     * @param element
     */
    private void processBeanDefinition(Element element) {
        
        String name=element.getAttribute("name");
        String className=element.getAttribute("class");
        BeanDefinition beanDefinition=new BeanDefinition();
        processProperty(element,beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name,beanDefinition);
        
    }

    /**
     * 创建里面的属性
     * @param element
     * @param beanDefinition
     */
    private void processProperty(Element element, BeanDefinition beanDefinition) {
        
        NodeList propertyList=element.getElementsByTagName("property");
        for(int i=0;i<propertyList.getLength();i++){
            Node node=propertyList.item(i);
            if(node instanceof  Element){
                Element propertyElement= (Element) node;
                String name=propertyElement.getAttribute("name");
                String value=propertyElement.getAttribute("value");
                if(value!=null && value.length()>0){
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                }else{
                    String ref=propertyElement.getAttribute("ref");
                    if(ref==null || ref.length()<=0){
                        throw  new IllegalArgumentException("配置问题,您的<property>元素里面"+name+"必须指定name 或者 ref 属性");
                    }
                    BeanReference beanReference=new BeanReference(ref);
                    beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,beanReference));
                }
            }
        }
        
    }
}
