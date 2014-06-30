package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

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
@Aspect
public class LoggingAfterReturningAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAfterReturningAspect.class);
	
	//引用到LoggingBeforeAspect定义的pointcut
	@AfterReturning(pointcut="LoggingBeforeAspect.service() && LoggingBeforeAspect.with()" +
			" && args(str) && target(obj) && this(proxy) ",returning="retur")
	public void afterReturningAspect(JoinPoint jp, String str, Object obj, Object proxy, Object retur){
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
		log.info(retur);
	}
	
}
