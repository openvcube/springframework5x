package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class MessageLoggerPojoVersion1 {

	protected static final Log log = LogFactory.getLog(MessageLoggerPojoVersion1.class);
	
	public void handleMessage(String message){
		log.info(message);
	}

}
