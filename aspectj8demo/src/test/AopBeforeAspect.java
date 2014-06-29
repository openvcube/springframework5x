/**
 * Copyright(c) http://www.open-v.com
 */
package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
public class AopBeforeAspect {

	private static final Log log = LogFactory.getLog(AopBeforeAspect.class);
	
	//定义匿名pointcut，并将传入setIj()的i暴露给这一装备
	@Before("set(int *InfoBefore.ij) && args(i)")
	public void xx(int i, JoinPoint thisJoinPoint){
		log.info(i + "");
		log.info(thisJoinPoint);
		log.info("AopBeforeAspect xx @Before");
	}

	//这里使用了call关键字，注意它同execution的区别
	@Pointcut("call(* *.compute(..))")
	public void yy(){}
	
	@Before("yy()")
	public void  zz(){
		log.info("AopBeforeAspect zz @Before");
	}

}