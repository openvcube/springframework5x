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
public class DisPersonInfo {

	private static final Log log = LogFactory.getLog(DisPersonInfo.class);

	public static void compute(String person) {
		log.info(person);
	}

	public static void compute(String person, int age) {
		log.info(person + "已经" + age + "岁了！");
	}

}
