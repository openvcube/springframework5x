package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  π”√autowire
 * 
 * @author worldheart
 */
public class AutowiredFineQualifierDemo {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("finequalifier.xml");

		TestBeanForFine testBeanForFine = (TestBeanForFine) ac
				.getBean("testBeanForFine");

		testBeanForFine.beanInfo();

	}

}