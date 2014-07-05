package test;

import javax.sql.DataSource;

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
public class MainTest {

	public static void main(String[] args) {

		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("ata.xml");

		DataSource ds = (DataSource)cbf.getBean("dataSource");
		
		//非受管Bean，这只是实例化普通的Java对象
		TransactionOpera to = new TransactionOpera();
		//进行了一次事务性操作
		to.updateDB(ds);

	}

}
