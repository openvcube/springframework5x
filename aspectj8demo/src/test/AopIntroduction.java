/**
 * Copyright(c) http://www.open-v.com
 */
package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
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
public class AopIntroduction {

	private static final Log log = LogFactory.getLog(AopIntroduction.class);

	@DeclareParents(value="test.DisPersonInfoIntroduction", defaultImpl=test.DefaultDisPersonInfoIntroduction.class)
	public IDisPersonInfoIntroduction dpi;

	@Pointcut("execution(* test.*InfoIntroduction.compute(..))")
	public void xx() {
	}

	@Around("xx() && this(dp)")
	public void yy(ProceedingJoinPoint pjp, IDisPersonInfoIntroduction dp)
			throws Throwable {
		log.info("AopIntroduction yy @Around");
		log.info(dp.getClass());
		pjp.proceed();
	}

}