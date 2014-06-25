package annotest;


import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author worldheart
 *
 */
public class HibernateTemplateOperationDemo {

	public static void main(String[] args){
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext("annotations.xml");
		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(lbf);
		
		IOperation hto = gbfa.getBean("hibernateTemplateOperation");
		hto.testOper();
		
	}
	
}
