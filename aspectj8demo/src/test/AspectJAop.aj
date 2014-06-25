/**
 * Copyright(c) http://www.open-v.com
 */
package test;


/**
 * 
 * <pre>
 * 程序的中文名称�??
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版�?:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public aspect AspectJAop {

	//private static final Log log = LogFactory.getLog(AspectJAop.class);

	pointcut xx()
		:  execution(* DisPersonInfo.compute(..));
	
	before(): xx() {
		//log.info("AspectJAop @Before");
		System.out.println("AspectJAop @Before");
	}
	
}
