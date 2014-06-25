package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 演示基于@Autowired注解的属性注入。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class AutowiredDemo {

	protected static final Log log = LogFactory.getLog(AutowiredDemo.class);

	public static void main(String[] args) {
		// 从classpath路径上装载XML配置信息
		ApplicationContext aac = new ClassPathXmlApplicationContext(
				"autowired.xml");
		// 获得受管Bean
		IHelloWorld helloWorld = (IHelloWorld) aac
				.getBean("autowiredHelloWorld");
		log.info(helloWorld.getContent());
	}

}