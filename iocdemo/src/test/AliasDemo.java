package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 别名演示。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class AliasDemo {

	private static final Log log = LogFactory.getLog(AliasDemo.class);

	public void getContent() {
		// 实例化IoC容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("alias.xml");
		
		// 获得受管Bean
		ITestBean tb1 = (ITestBean) ac.getBean("test.TestBean");
		ITestBean testBean = (ITestBean) ac.getBean("testBean");
		ITestBean tB = (ITestBean) ac.getBean("tB");
		ITestBean tb = (ITestBean) ac.getBean("tb");
	}

	public static void main(String[] args) {
		AliasDemo bfd = new AliasDemo();
		bfd.getContent();
	}

}