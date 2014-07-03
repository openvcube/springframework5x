package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 演示回调接口集合的使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ApplicationContextCallbackDemo {

	private static final Log log = LogFactory.getLog(ApplicationContextCallbackDemo.class);

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