package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

/**
 * 
 * @author worldheart
 *
 */
public class LoggingBeforeAspect {
	
	private static final Log log = LogFactory.getLog(LoggingBeforeAspect.class);
	
	/**
	 * 方法
	 * 
	 * @param jp JoinPoint连接点信息
	 * @param str 传入参数
	 * @param obj 代理目标
	 * @param proxy 代理本身
	 */
	public void beforeAspect(JoinPoint jp, String str, Object obj, Object proxy){
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
	}
	
}
