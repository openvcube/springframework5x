package test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class LoggingAroundAdvice implements MethodInterceptor{

	private static final Log log = LogFactory.getLog(LoggingAroundAdvice.class);

	public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("before: The Invocation of getContent()");
        log.info(invocation);
        
        invocation.getArguments()[0] = "world heart";
        Object returnValue = invocation.proceed();
        
        log.info("after: The Invocation of getContent()");

        return returnValue;
	}
	
}
