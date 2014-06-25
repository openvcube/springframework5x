package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * @author worldheart
 *
 */
@Aspect
public class LoggingBeforeAspect {
	
	private static final Log log = LogFactory.getLog(LoggingBeforeAspect.class);
	
	//将连接点作用范围圈定在service包中
	@Pointcut("within(*test.service.*)")
	public void with(){}

	//连接点对应的方法的返回值必须是void或java.lang.String
	@Pointcut("execution(public void || String test.service..*(..))")
	public void service(){}
	
	//进行与运算
	@Before("service() && with() && args(str) && target(obj) && this(proxy) ")
	public void beforeAspect(JoinPoint jp, String str, Object obj, Object proxy){
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
	}
	
}
