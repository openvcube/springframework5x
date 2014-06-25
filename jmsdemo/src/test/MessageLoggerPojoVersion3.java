package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class MessageLoggerPojoVersion3 {

	protected static final Log log = LogFactory.getLog(MessageLoggerPojoVersion3.class);
	
	public String handleMessage(String message){
		log.info(message);
		return "xx";
	}

}
