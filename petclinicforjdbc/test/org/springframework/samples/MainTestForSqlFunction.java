package org.springframework.samples;

import java.sql.Types;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.object.SqlFunction;

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
public class MainTestForSqlFunction {

	private static final Log log = LogFactory.getLog(MainTestForSqlFunction.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = 
			new ClassPathXmlApplicationContext("jdbctemplate.xml");		
		
		DataSource ds = (DataSource)cbf.getBean("dataSource");
		
		SqlFunction<Integer> sfInt = new SqlFunction<Integer>();
		sfInt.setDataSource(ds);
		sfInt.setSql("select count(*) from owners");
		sfInt.compile();
		int resultInt = sfInt.run();
		log.info(resultInt);
		
		sfInt = new SqlFunction<Integer>(ds,"select count(*) from owners where telephone like ? and last_name like ?");
		//声明参数类型
		sfInt.setTypes(new int[]{Types.VARCHAR, Types.VARCHAR});
		sfInt.compile();
		resultInt = sfInt.run(new Object[]{"16068008","Luo"});
		log.info(resultInt);
		
		SqlFunction<String> sfStr = new SqlFunction<String>(ds,"select address from owners where telephone like ? and last_name like ?");
		//声明参数类型
		sfStr.setTypes(new int[]{Types.VARCHAR, Types.VARCHAR});
		sfStr.compile();
		String resultStr = (String)sfStr.runGeneric(new Object[]{"16068008","Luo"}); 
		log.info(resultStr);
		
	}

}
