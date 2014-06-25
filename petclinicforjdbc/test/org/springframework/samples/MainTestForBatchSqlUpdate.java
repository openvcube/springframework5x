package org.springframework.samples;

import java.sql.Types;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.object.BatchSqlUpdate;

/**
 * 
 * @author worldheart
 * 
 */
public class MainTestForBatchSqlUpdate {

	private static final Log log = LogFactory
			.getLog(MainTestForBatchSqlUpdate.class);

	public static void main(String[] args) {
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext(
				"jdbctemplate.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);

		DataSource ds = gbfa.getBean("dataSource");

		final int[] no = new int[] { 7369, 7499, 7521, 7566, 7654, 7698 };

		BatchSqlUpdate bsu = new BatchSqlUpdate(ds,
				"update emp set sal = ? where empno = ?");
		bsu.setBatchSize(4);
		bsu.setTypes(new int[] { Types.FLOAT, Types.INTEGER });
		for (int i = 0; i < no.length; ++i) {
			log.info(bsu.update(new Object[] { no[i], no[i] }));
		}
		bsu.flush();
	}

}