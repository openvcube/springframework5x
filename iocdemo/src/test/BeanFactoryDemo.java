package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * HelloWorld客户应用
 * 
 * @author worldheart
 */
public class BeanFactoryDemo {

	protected static final Log log = LogFactory.getLog(BeanFactoryDemo.class);

	public static void main(String[] args) {
		//从classpath路径上装载XML配置信息
		Resource resource = new ClassPathResource("beanfactory.xml");
		//实例化IoC容器，此时，容器并未实例化beanfactory.xml所定义的各个受管Bean
		BeanFactory factory = new XmlBeanFactory(resource);
		//获得受管Bean
		IHelloWorld hw = (IHelloWorld) factory.getBean("helloWorld");
		//返回字符串
		log.info(hw.getContent());
	}

}