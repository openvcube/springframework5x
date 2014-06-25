package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * 
 * @author worldheart
 *
 */
public class LoggingAfterReturningAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAfterReturningAspect.class);
	
	public void afterReturningAspect(JoinPoint jp, Object retur){
		log.info(jp);
		log.info(retur);
	}
	
}
