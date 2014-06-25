package test;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

/**
 * 
 * @author worldheart
 *
 */
public class LoggingAfterThrowingAdvice implements ThrowsAdvice {

	protected static final Log log = LogFactory
			.getLog(LoggingAfterThrowingAdvice.class);

	public void afterThrowing(Method method, Object[] args, Object target,
			Throwable subclass) {
		log.info(method + "," + args[0] + "," + target);
		log.info(subclass);
	}

}
