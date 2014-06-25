package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * @author worldheart
 * 
 */
public class LoggingAroundAspect {

	private static final Log log = LogFactory.getLog(LoggingAroundAspect.class);

	public Object aroundAspect(ProceedingJoinPoint pjp, String str)
			throws Throwable {
		log.info(pjp);
		log.info(str);
		str = "worldheart changed!";
		return pjp.proceed(new Object[] { str });
	}

}