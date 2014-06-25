package test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 
 * @author worldheart
 * 
 */
public class JmsTemplateContainerDemo {

	protected static final Log log = LogFactory
			.getLog(JmsTemplateContainerDemo.class);

	public static void main(String[] args) {
		//container.xml¡¢jmscontainer.xml
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"container.xml");
		ac.registerShutdownHook();
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(ac);

		JmsTemplate jt = gbfa.getBean("jmsTemplate");
		
		jt.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session
						.createTextMessage("Hello World,queue/testQueue!");
			}
		});

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			log.error("", e);
		}

		System.exit(0);
	}

}
