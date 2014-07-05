package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
public class HSQLJdbcDemo {

	private static final Log log = LogFactory.getLog(HSQLJdbcDemo.class);
	
	public static void main(String[] args) {		
		try {
			//装载JDBC驱动
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e) {
			log.error("", e);
		}
		
		Properties prop = new Properties();
		prop.setProperty("username", "sa");
		prop.setProperty("password", "");
				
		try {
			//传入连接URL和相关属性
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001", prop);
			//创建Statement
			Statement stat = conn.createStatement();
			//执行SQL语句，并返回结果集
			ResultSet rs = stat.executeQuery("select * from pets");
			while(rs.next()){
				StringBuilder sb = new StringBuilder("id:" + rs.getInt("id"));
				sb.append(",name:" + rs.getString("name"));
				sb.append(",birth_date:" + rs.getDate("birth_date"));
				sb.append(",type_id:" + rs.getInt("type_id"));
				sb.append(",owner_id:" + rs.getInt("owner_id"));
				log.info(sb.toString());
			}
			//关闭相关资源
			rs.close();
			stat.close();
			conn.close();
		} catch (SQLException e) {
			log.error("", e);
		}		
	}

}
