package test;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 * 
 */
public class JmsDemo {

	protected static final Log log = LogFactory.getLog(JmsDemo.class);

	public static void main(String[] args) {
		Properties prop = new Properties();
		// prop.setProperty("java.naming.factory.initial",
		// "weblogic.jndi.WLInitialContextFactory");
		// prop.setProperty("java.naming.provider.url", "t3://localhost:7001");

		prop.setProperty("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		prop.setProperty("java.naming.provider.url", "jnp://localhost:1099");
		prop.setProperty("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");
		InitialContext ic = null;
		ConnectionFactory cf = null;
		Destination dest = null;
		Connection conn = null;
		Session session = null;
		MessageProducer producer = null;
		MessageConsumer consumer = null;
		TextMessage message = null;
		try {
			ic = new InitialContext(prop);
			cf = (ConnectionFactory) ic.lookup("ConnectionFactory");
			dest = (Destination) ic.lookup("queue/testQueue");
			conn = cf.createConnection();
			//创建非事务性Session
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			producer = session.createProducer(dest);
			message = session.createTextMessage();
			for (int i = 0; i < 5; ++i) {
				message.setText("消息" + (i + 1));
				log.info("发送消息: " + message.getText());
				//发送消息
				producer.send(message);
			}

			consumer = session.createConsumer(dest);
			//开始消费消息
			conn.start();
			while (true) {
				//接收消息
				Message m = consumer.receive(10);
				if (m != null) {
					if (m instanceof TextMessage) {
						message = (TextMessage) m;
						log.info("接收到消息: " + message.getText());
					}
				} else {
					break;
				}
			}
		} catch (NamingException ne) {
			log.error("", ne);
		} catch (JMSException je) {
			log.error("", je);
		} catch(Throwable exe){
			log.error("", exe);
		} finally {
			try {
				// 手工关闭所有的资源
				consumer.close();
				producer.close();
				session.close();
				conn.close();
				ic.close();
			} catch (JMSException jmse) {
				log.error("", jmse);
			} catch (NamingException ne) {
				log.error("", ne);
			}
		}
	}

}
