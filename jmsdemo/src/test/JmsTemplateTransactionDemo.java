package test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class JmsTemplateTransactionDemo {

	private static final Log log = LogFactory.getLog(JmsTemplateTransactionDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"transaction.xml");
		
		JmsTemplate jt = (JmsTemplate)ac.getBean("jmsTemplate");
		PlatformTransactionManager tm = (PlatformTransactionManager)ac.getBean("jmsTransactionManager");
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
