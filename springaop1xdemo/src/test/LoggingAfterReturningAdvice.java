package test;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

/**
 * 
 * @author worldheart
 *
 */
public class LoggingAfterReturningAdvice implements AfterReturningAdvice {

	protected static final Log log = 
		LogFactory.getLog(LoggingAfterReturningAdvice.class);
	
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		log.info(returnValue);
		log.info(method + "," + args[0] + "," + target);
		log.info("after: The Invocation of getContent()");
	}

}
