package test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

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
public class JmsTemplateContainerDemo {

	private static final Log log = LogFactory
			.getLog(JmsTemplateContainerDemo.class);

	public static void main(String[] args) {
		//container.xml��jmscontainer.xml
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(
				"container.xml");
		ac.registerShutdownHook();

		JmsTemplate jt = (JmsTemplate)ac.getBean("jmsTemplate");
		
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
