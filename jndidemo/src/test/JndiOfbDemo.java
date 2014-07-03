/**
 * 
 */
package test;

import javax.jms.JMSException;
import javax.jms.Queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 演示JndiObjectFactoryBean的使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class JndiOfbDemo {

	private static final Log log = LogFactory.getLog(JndiOfbDemo.class);
	
	public static void main(String[] args) {
		
		//jndiofb.xml、jndienv.xml、jndilookup.xml
		ApplicationContext ac = new ClassPathXmlApplicationContext("jndilookup.xml");
		
		//获得javax.jms.Queue对象
		Queue tq = (Queue)ac.getBean("tq");
		try{
			log.info(tq.getQueueName());
		} catch(JMSException je){
			log.error("", je);
		}
		
	}

}
