package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 查找方法注入。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class LookupDemo {

	protected static final Log log = LogFactory.getLog(LookupDemo.class);

	public static void main(String[] args) {
		//实例化IoC容器
		ApplicationContext aac = new ClassPathXmlApplicationContext("lookup.xml");
		
		//获得受管Bean
		LookupBeanImpl lb = (LookupBeanImpl)aac.getBean("lookupBean");
		
		log.info(lb.createAbstractLookedBean());
		log.info(lb.createAbstractLookedBean());
		
		log.info(lb.createLookedBean());
		log.info(lb.createLookedBean());
		
		log.info(lb.getCount());	
		log.info(lb.getName());
	}
	
}