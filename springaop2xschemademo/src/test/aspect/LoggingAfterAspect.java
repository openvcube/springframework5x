package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * 
 * @author worldheart
 *
 */
public class LoggingAfterAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAfterAspect.class);
	
	public void afterAspect(JoinPoint jp, String str){
		log.info(jp);
		log.info(str);
	}
	
}
