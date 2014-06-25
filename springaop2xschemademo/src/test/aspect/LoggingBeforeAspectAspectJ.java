package test.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * @author worldheart
 *
 */
@Aspect
public class LoggingBeforeAspectAspectJ {
	
	@Pointcut("execution(public void || String test.service..*(..))")
	public void before(){};
	
}
