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
