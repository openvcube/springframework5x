package test;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author worldheart
 * 
 */
public class HibernateTemplateOperDemo {

	public static void main(String[] args) {
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext(
				"hibernatetemplate.xml");

		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(lbf);

		IOper hto = gbfa.getBean("hibernateTemplateOper");
		hto.testOper();

	}

}
