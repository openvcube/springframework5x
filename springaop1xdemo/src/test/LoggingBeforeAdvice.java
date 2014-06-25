package test;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 
 * @author worldheart
 * 
 */
public class LoggingBeforeAdvice implements MethodBeforeAdvice {

	protected static final Log log = LogFactory
			.getLog(LoggingBeforeAdvice.class);

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		log.info(method + "," + args[0] + "," + target);
		log.info("before: The Invocation of getContent()");
		
	}

}
