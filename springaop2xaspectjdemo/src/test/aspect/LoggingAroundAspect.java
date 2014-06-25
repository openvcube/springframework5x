package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * @author worldheart
 *
 */
@Aspect
public class LoggingAroundAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAroundAspect.class);
	
	//传入str参数到@Around装备中
	@Pointcut("execution(public * test.service..*(..)) && args(str)")
	public void service(String str){}	
	
	@Around("service(str)" +
			" && target(obj) && this(proxy) ")
	public Object aroundAspect(ProceedingJoinPoint pjp, String str, Object obj, Object proxy){
		log.info(pjp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
		try {
			str = "worldheart changed!";
			return pjp.proceed(new Object[]{str});
		} catch (Throwable e) {
			log.error("", e);
		}
		return null;
	}
	
}