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
public class AutowiringCandidateDemo {

	protected static final Log log = LogFactory.getLog(AutowiringCandidateDemo.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("autowire-candidate.xml");
		
		TestBean4 testBean4 = (TestBean4)ac.getBean("testBean4");
		
		log.info(testBean4.getTestBean5());
		
		TestBean6 testBean6 = (TestBean6)ac.getBean("testBean6");
		
		log.info(testBean6.getTestBean4());
				
	}

}