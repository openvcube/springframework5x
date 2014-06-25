package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  π”√autowire
 * 
 * @author worldheart
 */
public class AutowiredDemo {

	protected static final Log log = LogFactory.getLog(AutowiredDemo.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("autowired.xml");
		
		TestBean1 testBean1 = (TestBean1)ac.getBean("testBean1");
		
		log.info(testBean1.getTestBean2());
		log.info(testBean1.getTestBean3());
						
	}

}