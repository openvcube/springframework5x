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
public class JmxServerConnectorDemo {
	
	protected static final Log log = LogFactory.getLog(JmxServerConnectorDemo.class);

	public static void main(String[] args) {		
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext("connectorserver.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(lbf);
		
		IUserInfo ui = gbfa.getBean("userInfo");
		
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ie) {
				log.error("", ie);
			}
		}
	}
}
