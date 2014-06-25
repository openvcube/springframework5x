package test;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 * 
 */
public class MessageLogger implements MessageListener {

	protected static final Log log = LogFactory.getLog(MessageLogger.class);

	public void onMessage(Message message) {
		log.info(message);
	}

}
