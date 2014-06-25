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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 
 * @author worldheart
 * 
 */
public class JmsTemplateTransactionDemo {

	protected static final Log log = LogFactory.getLog(JmsTemplateTransactionDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"transaction.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(ac);
		
		JmsTemplate jt = gbfa.getBean("jmsTemplate");
		PlatformTransactionManager tm = gbfa.getBean("jmsTransactionManager");
		TransactionStatus ts = tm.getTransaction(new DefaultTransactionDefinition());
		jt.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("Hello World1,queue/testQueue!");
			}
		});
		jt.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("Hello World2,queue/testQueue!");
			}
		});
		tm.commit(ts);

//		ts = tm.getTransaction(new DefaultTransactionDefinition());
		while(true){
			TextMessage message = (TextMessage) jt.receive();
			if(message == null) break;
			try {
				log.info(message.getText());
			} catch (JMSException ex) {
				log.error("", ex);
			}
		}
//		tm.commit(ts);
	}
}
