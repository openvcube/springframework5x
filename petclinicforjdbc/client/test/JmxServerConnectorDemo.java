package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
public class JmxServerConnectorDemo {
	
	private static final Log log = LogFactory.getLog(JmxServerConnectorDemo.class);

	public static void main(String[] args) {		
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext("connectorserver.xml");
		
		IUserInfo ui = (IUserInfo)lbf.getBean("userInfo");
		
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ie) {
				log.error("", ie);
			}
		}
	}
}
