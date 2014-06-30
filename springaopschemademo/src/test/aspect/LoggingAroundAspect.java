package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

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