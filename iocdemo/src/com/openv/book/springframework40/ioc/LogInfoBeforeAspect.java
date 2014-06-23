package com.openv.book.springframework40.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * <pre>
 * 输出调用日志AspectJ AOP切面
 * </pre>
 * @author openvcube  openvcube@open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
@Aspect
public class LogInfoBeforeAspect {

	private static final Log log = LogFactory.getLog(LogInfoBeforeAspect.class);
		
	@Before("execution(* *.*(..))")
	public void invokeInfo(JoinPoint thisJoinPoint){
		Signature signature = thisJoinPoint.getSignature();
		log.info(signature.toString());
	}

}