package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
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
public class LoggingAfterThrowingAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAfterThrowingAspect.class);
	
	//引用到LoggingBeforeAspect定义的pointcut
	@AfterThrowing(pointcut="LoggingBeforeAspect.service() && LoggingBeforeAspect.with()" +
			" && args(str) && target(obj) && this(proxy) ",throwing="thro")
	public void afterThrowingAspect(JoinPoint jp, String str, Object obj, Object proxy, RuntimeException thro){
		log.info("afterThrowingAspect....................");
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
		log.info(thro);
	}
	
	//引用到LoggingBeforeAspect定义的pointcut
	@After("LoggingBeforeAspect.service() && LoggingBeforeAspect.with()" +
			" && args(str) && target(obj) && this(proxy) ")
	public void afterAspect(JoinPoint jp, String str, Object obj, Object proxy){
		log.info("afterAspect....................");
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
	}
	
}
