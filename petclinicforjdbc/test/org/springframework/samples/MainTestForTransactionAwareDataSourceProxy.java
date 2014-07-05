package org.springframework.samples;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
public class MainTestForTransactionAwareDataSourceProxy {

	private static final Log log = LogFactory.getLog(MainTestForTransactionAwareDataSourceProxy.class);
	
	public static void main(String[] args) {
		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("dsproxy.xml");		
		
		TransactionTemplate tt = (TransactionTemplate)cbf.getBean("transactionTemplate");
		
		//如果将dataSource替换成dataSourceTarget，
		//则即使status.setRollbackOnly()执行了，last_name还是被更新了
		final DataSource ds = (DataSource)cbf.getBean("dataSource");
		
		tt.execute(new TransactionCallbackWithoutResult(){
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				Connection conn = null;
				Statement stat = null;				
				try{
					conn = ds.getConnection();
					stat = conn.createStatement();
					log.info(stat.executeUpdate(
							"update owners set last_name = 'Luo' where telephone = '16068008'"));
					//标识事务回滚
					status.setRollbackOnly();
				}catch(SQLException exec){
					log.error("", exec);
				} finally{
					JdbcUtils.closeStatement(stat);
					JdbcUtils.closeConnection(conn);
				}
			}
		});
	}

}