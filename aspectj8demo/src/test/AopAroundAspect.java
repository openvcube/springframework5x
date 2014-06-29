/**
 * Copyright(c) http://www.open-v.com
 */
package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

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
public class AopAroundAspect {

	private static final Log log = LogFactory.getLog(AopAroundAspect.class);

	@Pointcut("execution(* test.*InfoAround.compute(..)) && args(String)")
	public void xx() {
	}

	@Around("xx() && args(persion)")
	public void yy(ProceedingJoinPoint pjp, String persion) {
		log.info("AopAroundAspect yy @Around");
		try {
			log.info(persion);
			//替换原先的persion
			persion = "李三";			
			pjp.proceed(new Object[]{persion});
		} catch (Throwable thro) {
			log.error("", thro);
		}
	}

	@Around("xx()")
	public void zz(ProceedingJoinPoint pjp) throws Throwable {
		log.info("AopAroundAspect zz @Around");
		log.info(pjp);
		pjp.proceed();
	}

}