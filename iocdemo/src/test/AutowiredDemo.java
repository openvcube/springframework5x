package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示基于@Autowired注解的属性注入
 * 
 * @author worldheart
 */
public class AutowiredDemo {

	protected static final Log log = LogFactory.getLog(AutowiredDemo.class);

	public static void main(String[] args) {
		// 从classpath路径上装载XML配置信息
		ApplicationContext cac = new ClassPathXmlApplicationContext(
				"autowired.xml");
		// 获得受管Bean
		IHelloWorld helloWorld = (IHelloWorld) cac
				.getBean("autowiredHelloWorld");
		log.info(helloWorld.getContent());
	}

}