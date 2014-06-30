package test;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

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
public class LoggingAfterThrowingAdvice implements ThrowsAdvice {

	private static final Log log = LogFactory
			.getLog(LoggingAfterThrowingAdvice.class);

	public void afterThrowing(Method method, Object[] args, Object target,
			Throwable subclass) {
		log.info(method + "," + args[0] + "," + target);
		log.info(subclass);
	}

}
