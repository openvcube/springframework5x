package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 演示SpEL的使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class SpelDemo2 {

	private static final Log log = LogFactory.getLog(SpelDemo2.class);

	public static void main(String[] args) {

		//dependson1.xml或dependson2.xml
		new ClassPathXmlApplicationContext("spel.xml");

	}

}
