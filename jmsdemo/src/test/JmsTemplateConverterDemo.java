package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * 
 * @author worldheart
 * 
 */
public class JmsTemplateConverterDemo {

	protected static final Log log = LogFactory.getLog(JmsTemplateConverterDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"converter.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(ac);
		
		JmsTemplate jt = gbfa.getBean("jmsTemplate");
		
		UserPassInfo upi = new UserPassInfo();
		upi.setUsername("spring");
		upi.setPassword("dragon");
		
		jt.convertAndSend(upi);
		
		while(true){
			UserPassInfo up = (UserPassInfo) jt.receiveAndConvert();
			if(up == null) break;
			log.info(up);
		}		

	}
	
}
