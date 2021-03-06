/**
 * Copyright(c) http://www.open-v.com
 */
package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.After;
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
public class AopAfterAspect {

	private static final Log log = 
		LogFactory.getLog(AopAfterAspect.class);
	
	@Pointcut("execution(* test.*InfoAfter.compute(..))")
	public void xx(){}
	
	@After("xx()")
	public void yy(){		
		log.info("AopAfterAspect yy @After");
	}
	
	@After("xx()")
	public void zz(){
		log.info("AopAfterAspect zz @After");
	}
	
}