package test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
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
