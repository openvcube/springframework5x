/**
 * 
 */
package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * File System示例使用(Spring版本)。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class FsTestSpringClient {

	private static final Log log = LogFactory.getLog(FsTestClient.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("fs.xml");
		
		Object fc = ac.getBean("fc");		
		log.info(fc);
		
	}

}
