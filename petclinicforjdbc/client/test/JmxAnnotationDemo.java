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
public class JmxAnnotationDemo {
	
	protected static final Log log = LogFactory.getLog(JmxAnnotationDemo.class);

	public static void main(String[] args) {
		//annotation.xml、contextmbean.xml、notificationlisteners.xml、notificationlistenermappings.xml
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext("annotation.xml");
		
		IUserInfo ui = (IUserInfo)lbf.getBean("userInfo:spring=userInfo");
		
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ie) {
				log.error("", ie);
			}
			log.info(ui);
			ui.updateUserInfo("spring", "dragon");
		}
	}
}
