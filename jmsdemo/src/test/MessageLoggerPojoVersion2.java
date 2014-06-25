package test;

import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class MessageLoggerPojoVersion2 {

	protected static final Log log = LogFactory.getLog(MessageLoggerPojoVersion2.class);
	
	public void receiveMessage(TextMessage message){
		log.info(message);
	}

}
