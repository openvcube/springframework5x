/**
 * Copyright(c) http://www.open-v.com
 */
package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
public class DisPersonInfoAfterReturning {

	private static final Log log = LogFactory.getLog(DisPersonInfoAfterReturning.class);

	public void compute(String person) {
		log.info(person);
	}

	public String compute(String person, int age) {
		// 单线程环境中，
		// JDK 5.0引入的StringBuilder比原先的StringBuffer性能更好
		StringBuilder sb = new StringBuilder(person);		
		sb.append("已经" + age + "岁了！");		
		return sb.toString();		
	}

}
