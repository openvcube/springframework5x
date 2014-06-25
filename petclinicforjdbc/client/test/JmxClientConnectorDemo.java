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
public class JmxClientConnectorDemo {
	
	protected static final Log log = LogFactory.getLog(JmxClientConnectorDemo.class);

	public static void main(String[] args) {		
		ListableBeanFactory lbf = 
				new ClassPathXmlApplicationContext("connectorclient.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(lbf);
		
		IUserInfo ui = gbfa.getBean("proxyUserInfo");
		ui.setUserName("spring 2.x");
		log.info(ui.getUserName());
	}
	
}
