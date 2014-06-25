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
public class RequiredDemo {

	protected static final Log log = LogFactory.getLog(RequiredDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("required.xml");

		ITestBean tb = (ITestBean) ac.getBean("testBean");

		tb.testBean();

	}

}