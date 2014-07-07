package org.springframework.samples;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.UpdatableSqlQuery;

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
public class MainTestForUpdatableSqlQuery {

	private static final Log log = LogFactory.getLog(MainTestForUpdatableSqlQuery.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = 
			new ClassPathXmlApplicationContext("jdbctemplate.xml");		
		
		DataSource ds = (DataSource)cbf.getBean("dataSource");
		
		//为更新操作提供可选的上下文信息
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(4, "Xxx");
		
		OwnersUpdateQuery ouq = new OwnersUpdateQuery(ds);
		List list = ouq.execute(7900, map);
		
		log.info(list);
	}

}

class OwnersUpdateQuery extends UpdatableSqlQuery<String> {

	public OwnersUpdateQuery(DataSource ds) {
		super(ds, "select ename from emp where empno = ?");
		declareParameter(new SqlParameter(Types.INTEGER));
		compile();
	}

	protected String updateRow(ResultSet rs, int rownum, Map context) 
		throws SQLException {
		rs.updateString(1, "" + rs.getString("ename") + " " + context.get(4));
		return rs.getString("ename");
	}
	
}
