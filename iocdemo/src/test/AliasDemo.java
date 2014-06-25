package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示通过构造器注入factory-bean、factory-method所需的参数
 * 
 * @author worldheart
 */
public class AliasDemo {

	protected static final Log log = LogFactory.getLog(AliasDemo.class);

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