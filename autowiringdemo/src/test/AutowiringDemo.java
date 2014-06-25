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
public class AutowiringDemo {

	protected static final Log log = LogFactory.getLog(AutowiringDemo.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("autowire.xml");
		
		TestBean1 tbByName = (TestBean1)ac.getBean("tbByName");
		
		log.info(tbByName.getTestBean2());
		log.info(tbByName.getTestBean3());
		
		TestBean1 tbByType = (TestBean1)ac.getBean("tbByType");
		
		log.info(tbByType.getTestBean2());
		log.info(tbByType.getTestBean3());
		
		TestBean1 tbConstructor = (TestBean1)ac.getBean("tbConstructor");
		
		log.info(tbConstructor.getTestBean2());
		log.info(tbConstructor.getTestBean3());

		TestBean1 tbAutodetect = (TestBean1)ac.getBean("tbAutodetect");
		
		log.info(tbAutodetect.getTestBean2());
		log.info(tbAutodetect.getTestBean3());
		
	}

}