package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

import test.IIntroductionInfo;

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
public class LoggingIntroductionAspect {
	
	private static final Log log = LogFactory.getLog(LoggingIntroductionAspect.class);
	
	@DeclareParents(value="test.service.*",defaultImpl=test.IntroductionInfoImpl.class)
	public IIntroductionInfo iInfo;
	
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
			log.error(e);
		}
		return null;
	}
	
}