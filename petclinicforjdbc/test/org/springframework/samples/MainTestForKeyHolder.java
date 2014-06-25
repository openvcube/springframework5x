package org.springframework.samples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 * 
 * @author worldheart
 * 
 */
public class MainTestForKeyHolder {

	private static final Log log = LogFactory.getLog(MainTestForKeyHolder.class);

	public static void main(String[] args) {
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext(
				"npjdbctemplate.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);

		JdbcTemplate jt = gbfa.getBean("jdbcTemplate");

		KeyHolder kh = new GeneratedKeyHolder();
		
		jt.update(new PreparedStatementCreator(){
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement  ps = 
					con.prepareStatement("insert into emp(empno, ename) values(?, ?)",
						new String[]{"empno", "ename", "mgr"});
				ps.setInt(1, 8000);
				ps.setString(2, "lsf");
				return ps;
			}
		}, kh);

		log.info(kh.getKeyList());
	}

}