package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 演示构造器注入
 * 
 * @author worldheart
 */
public class ConstructorDemo {

	protected static final Log log = LogFactory.getLog(ConstructorDemo.class);

	public void getContent(){
		//从classpath路径上装载XML配置信息
		Resource resource = new ClassPathResource("constructor.xml");
		//实例化IoC容器
		BeanFactory factory = new XmlBeanFactory(resource);
		//获得受管POJO
		IHelloStr hs1 = (IHelloStr) factory.getBean("fileHello1");
		IHelloStr hs2 = (IHelloStr) factory.getBean("fileHello2");
		IHelloStr hs3 = (IHelloStr) factory.getBean("fileHello3");
		IHelloStr hs4 = (IHelloStr) factory.getBean("fileHello4");
		IHelloStr hs5 = (IHelloStr) factory.getBean("fileHello5");
		IHelloStr hs6 = (IHelloStr) factory.getBean("fileHello6");
		IHelloStr hs7 = (IHelloStr) factory.getBean("fileHello6");
	}

	public static void main(String[] args) {
		ConstructorDemo bfd = new ConstructorDemo();
		bfd.getContent();
	}
	
}