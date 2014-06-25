package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterReturning;
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
public class AopAfterReturningAspect {

	private static final Log log = 
		LogFactory.getLog(AopAfterReturningAspect.class);
	
	@Pointcut("execution(* *InfoAfterReturning.compute(..))")
	public void xx(){}
	
	@AfterReturning("xx()")
	public void yy(){
		log.info("AopAfterReturningAspect yy @AfterReturning");
	}
		
	@AfterReturning(pointcut="xx()",returning="str")
	public void zz(String str){
		log.info(str);
		log.info("AopAfterReturningAspect zz @AfterReturning");
	}
	
}