package test;

import javax.sql.DataSource;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author worldheart
 * 
 */
public class MainTest {

	public static void main(String[] args) {

		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("ata.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);

		DataSource ds = gbfa.getBean("dataSource");
		
		//非受管Bean，这只是实例化普通的Java对象
		TransactionOpera to = new TransactionOpera();
		//进行了一次事务性操作
		to.updateDB(ds);

	}

}
