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
public class HelloClientBefore {

	private static final Log log = LogFactory.getLog(HelloClientBefore.class);

	public static void main(String[] args) {

		//开发者可以动态切换到不同的XML配置文件
		ListableBeanFactory factory = new ClassPathXmlApplicationContext(
				"before.xml");

		IHelloWorld hw = (IHelloWorld)factory.getBean("helloworldbean");

		log.info(hw.getContent("worldheart"));

	}

}
