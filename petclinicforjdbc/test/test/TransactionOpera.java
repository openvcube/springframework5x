package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class TransactionOpera {

	private static final Log log = LogFactory.getLog(TransactionOpera.class);
		
	public void updateDB(DataSource ds) {
		try{
			//借助于Spring Framework提供的DataSourceUtils实用类，
			//获得当前事务已经征集的Connection对象
			Connection conn = DataSourceUtils.getConnection(ds);
			Statement stat = conn.createStatement();
			log.info(
					stat.executeUpdate(
							"update owners set last_name = 'Luo' where id = 2"));
			//需要手工关闭Statement，但是我们不能够关闭conn，
			//因为当前事务完结时Spring会负责关闭它
			stat.close();
			//抛出异常，开发者可以去数据库检查当前RDBMS数据是否一致，
			//或者可以将如下语句屏蔽掉
			throw new RuntimeException("xx");
		} catch(SQLException sql){
			throw new RuntimeException(sql);
		}
	}
	
}
