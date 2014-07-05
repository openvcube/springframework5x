package org.springframework.samples;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

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
public class MainTestForRowSet {

	private static final Log log = LogFactory.getLog(MainTestForRowSet.class);

	public static void main(String[] args) {
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext(
				"npjdbctemplate.xml");

		JdbcTemplate jt = (JdbcTemplate)cbf.getBean("jdbcTemplate");

		SqlRowSet rs = jt.queryForRowSet("select empno, sal from emp");

		while (rs.next()) {
			log.info(rs.getString("empno") + ":->" + rs.getFloat("sal"));
		}
		
		NamedParameterJdbcTemplate npjt = (NamedParameterJdbcTemplate)cbf.getBean("namedParameterJdbcTemplate");

		Map<String,String> map = new HashMap<String,String>();
		map.put("job", "CLERK");	
		
		SqlRowSet srs = npjt.queryForRowSet("select empno, sal from emp where job = :job", map);
		
		while (srs.next()) {
			log.info(srs.getString("empno") + ":->" + srs.getFloat("sal"));
		}
		
	}

}