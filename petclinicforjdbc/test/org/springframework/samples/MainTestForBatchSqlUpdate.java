package org.springframework.samples;

import java.sql.Types;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.object.BatchSqlUpdate;

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
public class MainTestForBatchSqlUpdate {

	private static final Log log = LogFactory
			.getLog(MainTestForBatchSqlUpdate.class);

	public static void main(String[] args) {
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext(
				"jdbctemplate.xml");

		DataSource ds = (DataSource)cbf.getBean("dataSource");

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