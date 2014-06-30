package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

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
public class LoggingAfterThrowingAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAfterThrowingAspect.class);
	
	public void afterThrowingAspect(JoinPoint jp, RuntimeException thro){
		log.info(jp);
		log.info(thro);
	}
	
}
