package org.springframework.samples;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.InterruptibleBatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.AbstractInterruptibleBatchPreparedStatementSetter;

/**
 * 
 * @author worldheart
 *
 */
public class MainTestForBatchPreparedStatementSetter {

	private static final Log log = LogFactory.getLog(MainTestForBatchPreparedStatementSetter.class);
	
	public static void main(String[] args) {
		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("jdbctemplate.xml");		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);
		
		JdbcTemplate jt = gbfa.getBean("jdbcTemplate");
		
		final int[] no = new int[]{7369,7499,7521,7566,7654,7698};
		
		jt.batchUpdate("update emp set sal = ? where empno = ?", 
					new BatchPreparedStatementSetter(){
							public void setValues(PreparedStatement ps, int i) throws SQLException {
								ps.setInt(1, no[i]);
								ps.setFloat(2, no[i]);
							}
							public int getBatchSize() {
								return no.length;
							}
					});
		
		jt.batchUpdate("update emp set sal = ? where empno = ?", 
				new InterruptibleBatchPreparedStatementSetter(){
							public void setValues(PreparedStatement ps, int i) throws SQLException {
								ps.setInt(1, no[i]);
								ps.setFloat(2, no[i]);
							}
							public int getBatchSize() {
								return no.length;
							}
							public boolean isBatchExhausted(int i) {
								if(i == 3) return true;
								return false;
							}
				});

		jt.batchUpdate("update emp set sal = ? where empno = ?", 
				new AbstractInterruptibleBatchPreparedStatementSetter(){
						protected boolean setValuesIfAvailable(PreparedStatement ps, int i) 
							throws SQLException {
							if(i < no.length && i != 3){
								ps.setInt(1, no[i]);
								ps.setFloat(2, no[i]);
								return true;
							} else{
								return false;
							}
						}
				});		
	}

}