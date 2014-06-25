package test;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

/**
 * 
 * @author worldheart
 *
 */
public class MessageLoggerSessionAware implements SessionAwareMessageListener {

	protected static final Log log = LogFactory.getLog(MessageLoggerSessionAware.class);
	
	public void onMessage(Message message, Session session) throws JMSException {
		log.info(message);
		log.info(session);
	}

}
