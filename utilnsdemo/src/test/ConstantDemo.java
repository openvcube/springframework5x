package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 各类FactoryBean的使用
 * 
 * @author worldheart
 */
public class ConstantDemo {

	protected static final Log log = LogFactory.getLog(ConstantDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("constant.xml");
		
		log.info(ac.getBean("test.HelloWorld.hwStatic"));
		log.info(ac.getBean("helloWorld"));
		log.info(ac.getBean("hwConstant"));			
	}

}