package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author worldheart
 * 
 */
public class JpaPersistenceContextDemo {

	protected static final Log log = LogFactory.getLog(JpaPersistenceContextDemo.class);

	public static void main(String[] args) {
		
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext("persistencecontext.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(lbf);
		
		JpaInfoImpl ji = gbfa.getBean("jpaInfo");
		
		ji.testOper();
		
	}
	
}