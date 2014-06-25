package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author worldheart
 * 
 */
public class JmxSpringDemo {
	
	protected static final Log log = LogFactory.getLog(JmxSpringDemo.class);

	public static void main(String[] args) {		
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext("mbeanexporter.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(lbf);
		
		UserInfoMBean ui = gbfa.getBean("bean:ui=userinfo");
		
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ie) {
				log.error("", ie);
			}
			log.info(ui);
		}
	}
}
