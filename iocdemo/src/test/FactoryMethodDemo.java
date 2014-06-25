package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 演示factory-method
 * 
 * @author worldheart
 */
public class FactoryMethodDemo {

	protected static final Log log = LogFactory.getLog(FactoryMethodDemo.class);

	public String getContent(){
		//从classpath路径上装载XML配置信息
		Resource resource = new ClassPathResource("factorymethod.xml");
		//实例化IoC容器
		BeanFactory factory = new XmlBeanFactory(resource);
		//获得受管POJO
		IHelloWorld hw = (IHelloWorld) factory.getBean("helloWorld");
		//返回字符串
		return hw.getContent();
	}

	public static void main(String[] args) {
		FactoryMethodDemo bfd = new FactoryMethodDemo();
		//输出返回结果
		log.info(bfd.getContent());
	}
	
}