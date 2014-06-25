package org.springframework.samples;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.JdbcUtils;

/**
 * 
 * @author worldheart
 *
 */
public class MainTestForLocalTransaction {

	private static final Log log = LogFactory.getLog(MainTestForLocalTransaction.class);
	
	public static void main(String[] args) {			
		
		ListableBeanFactory cbf = 
			new ClassPathXmlApplicationContext("localtransaction.xml");		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);		
		DataSource ds = gbfa.getBean("dataSource");
		
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
