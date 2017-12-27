package com.wanghao.ioc.xml;/**
 * Created by Administrator on 2017/12/27.
 */

import com.wanghao.ioc.AbstractBeanDefinitionReader;
import com.wanghao.ioc.BeanDefinition;
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
        InputStream inputStream=getResourceLoad().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    /**
     * 加载beanDefination
     * @param inputStream
     */
    private void doLoadBeanDefinitions(InputStream inputStream) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder=factory.newDocumentBuilder();
        Document document= documentBuilder.parse(inputStream);
        registerBeanDefinitions(document);
        inputStream.close();
    }

    /**
     * 解析bean的xml文件
     * @param document
     */
    private void registerBeanDefinitions(Document document) {
      Element root=  document.getDocumentElement();
      parseBeanDefinitions(root);
    }

    /**
     * 解析dom文档
     * @param root
     */
    private void parseBeanDefinitions(Element root) {
        
        NodeList lists=root.getChildNodes();
        for(int i=0;i<lists.getLength();i++){
            Node node=lists.item(i);
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
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
            }
        }
        
    }
}
