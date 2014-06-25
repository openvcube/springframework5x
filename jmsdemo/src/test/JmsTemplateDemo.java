package test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.MessagePostProcessor;

/**
 * 
 * @author worldheart
 * 
 */
public class JmsTemplateDemo {

	protected static final Log log = LogFactory.getLog(JmsTemplateDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"jmstemplate.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(ac);
		
		JmsTemplate jt = gbfa.getBean("jmsTemplate");
		jt.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("Hello World,queue/testQueue!");
			}
		});
				
		jt.convertAndSend("Hello World,queue/testQueue!");
		
		Object str = "Hello World,queue/testQueue!";
		jt.convertAndSend(str, new MessagePostProcessor(){
			public Message postProcessMessage(Message message) throws JMSException {
				TextMessage tm = (TextMessage)message;
				tm.setText(tm.getText() + " Version2");
				return tm;
			}
		});
		
		while(true){
			TextMessage message = (TextMessage) jt.receive();
			if(message == null) break;
			try {
				log.info(message.getText());
			} catch (JMSException ex) {
				log.error("", ex);
			}
		}
		

	}
}
