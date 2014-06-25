package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示抽象Bean和子Bean
 * 
 * @author worldheart
 */
public class TestAbstractBeanDemo {

	protected static final Log log = LogFactory.getLog(TestAbstractBeanDemo.class);

	public static void main(String[] args) {
		//实例化IoC容器
		AbstractApplicationContext aac = 
			new ClassPathXmlApplicationContext("testabstractbean.xml");

		log.info(aac.getBean("childBean1"));
		log.info(aac.getBean("childBean2"));
		log.info(aac.getBean("childBean3"));
		log.info(aac.getBean("childBean4"));
		
	}
	
}