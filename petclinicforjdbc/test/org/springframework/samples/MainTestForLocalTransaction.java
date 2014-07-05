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
public class MainTestForLocalTransaction {

	private static final Log log = LogFactory.getLog(MainTestForLocalTransaction.class);
	
	public static void main(String[] args) {					
		ListableBeanFactory cbf = 
			new ClassPathXmlApplicationContext("localtransaction.xml");		
		DataSource ds = (DataSource)cbf.getBean("dataSource");
		
		Connection conn = null;
		Statement stat = null;
		
		try{
			conn = ds.getConnection();
			boolean autoCommit = conn.getAutoCommit();
			if(autoCommit)
				conn.setAutoCommit(false);
			stat = conn.createStatement();
			stat.executeUpdate("update vets set first_name = 'user name' where id = 1");
			conn.commit();
		}catch(SQLException sqle){
			log.error("", sqle);
		}finally{
			JdbcUtils.closeStatement(stat);
			JdbcUtils.closeConnection(conn);
		}		
	}

}
