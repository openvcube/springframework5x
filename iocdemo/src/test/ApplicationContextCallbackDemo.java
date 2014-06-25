package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示回调接口集合的使用
 * 
 * @author worldheart
 */
public class ApplicationContextCallbackDemo {

	protected static final Log log = LogFactory.getLog(ApplicationContextCallbackDemo.class);

	public String getContent(){
		//实例化IoC容器
		AbstractApplicationContext aac = 
			new ClassPathXmlApplicationContext("applicationcontext-callback.xml");

		//注册JVM 钩子（Hook）
		aac.registerShutdownHook();
		
		//获得受管Bean
		ITestBean hw = (ITestBean) aac.getBean("testBean");
		
		//返回字符串
		return hw.testBean();
	}

	public static void main(String[] args) {
		ApplicationContextCallbackDemo acd = new ApplicationContextCallbackDemo();
		//输出返回结果
		log.info(acd.getContent());
	}
	
}