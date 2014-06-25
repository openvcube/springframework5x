package org.springframework.samples;

import java.sql.Types;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.object.SqlFunction;

/**
 * 
 * @author worldheart
 *
 */
public class MainTestForSqlFunction {

	private static final Log log = LogFactory.getLog(MainTestForSqlFunction.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = 
			new ClassPathXmlApplicationContext("jdbctemplate.xml");		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);
		
		DataSource ds = gbfa.getBean("dataSource");
		
		SqlFunction sf = new SqlFunction();
		sf.setDataSource(ds);
		sf.setSql("select count(*) from owners");
		sf.compile();	
		int result = sf.run();
		log.info(result);
		
		sf = new SqlFunction(ds,"select count(*) from owners where telephone like ? and last_name like ?");
		//声明参数类型
		sf.setTypes(new int[]{Types.VARCHAR, Types.VARCHAR});
		sf.compile();
		result = sf.run(new Object[]{"16068008","Luo"});
		log.info(result);
		
		sf = new SqlFunction(ds,"select address from owners where telephone like ? and last_name like ?");
		//声明参数类型
		sf.setTypes(new int[]{Types.VARCHAR, Types.VARCHAR});
		//设定返回类型（可选）
		sf.setResultType(String.class);
		sf.compile();
		String resultStr = (String)sf.runGeneric(new Object[]{"16068008","Luo"}); 
		log.info(resultStr);		
		
	}

}
