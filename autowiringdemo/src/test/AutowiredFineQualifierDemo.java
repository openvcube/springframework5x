package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 使用autowire。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class AutowiredFineQualifierDemo {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("finequalifier.xml");

		TestBeanForFine testBeanForFine = (TestBeanForFine) ac
				.getBean("testBeanForFine");

		testBeanForFine.beanInfo();

	}

}