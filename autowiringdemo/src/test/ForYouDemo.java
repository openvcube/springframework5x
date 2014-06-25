package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ≤‚ ‘≤¢ π”√@Required
 * 
 * @author worldheart
 */
public class ForYouDemo {

	protected static final Log log = LogFactory.getLog(ForYouDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("foryou.xml");
		
		ITestBean tb = (ITestBean)ac.getBean("testBean");
		
		tb.testBean();
		
	}

}