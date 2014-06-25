package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * 
 * @author worldheart
 *
 */
public class LoggingAfterThrowingAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAfterThrowingAspect.class);
	
	public void afterThrowingAspect(JoinPoint jp, RuntimeException thro){
		log.info(jp);
		log.info(thro);
	}
	
}
