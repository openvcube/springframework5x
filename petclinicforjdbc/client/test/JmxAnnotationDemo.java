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
public class JmxAnnotationDemo {
	
	protected static final Log log = LogFactory.getLog(JmxAnnotationDemo.class);

	public static void main(String[] args) {
		//annotation.xml¡¢contextmbean.xml¡¢notificationlisteners.xml¡¢notificationlistenermappings.xml
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext("annotation.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(lbf);
		
		IUserInfo ui = gbfa.getBean("userInfo:spring=userInfo");
		
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ie) {
				log.error("", ie);
			}
			log.info(ui);
			ui.updateUserInfo("spring", "dragon");
		}
	}
}
