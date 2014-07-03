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
public class JpaTemplateOperDemo {

	protected static final Log log = LogFactory.getLog(JpaTemplateOperDemo.class);

	public static void main(String[] args) {
		
		//Ö§³Öjpatemplate.xml¡¢localcontainer.xml¡¢persistenceunitmanager.xml¡¢datasourcelookup.xml¡¢persistencexmllocations.xml
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext("jpatemplate.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(lbf);
		
		IOper jidi = gbfa.getBean("jpaTemplateOper");
		
		jidi.testOper();
		
	}
	
}