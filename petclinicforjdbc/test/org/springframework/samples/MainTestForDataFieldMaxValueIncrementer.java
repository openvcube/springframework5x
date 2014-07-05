package org.springframework.samples;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

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
public class MainTestForDataFieldMaxValueIncrementer {

	private static final Log log = LogFactory.getLog(MainTestForDataFieldMaxValueIncrementer.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("jdbctemplate.xml");		
		
		DataSource ds = (DataSource)cbf.getBean("dataSource");
		
		DataFieldMaxValueIncrementer dfmvi = 
			new OracleSequenceMaxValueIncrementer(ds, "HIBERNATE_SEQUENCE");
		log.info(dfmvi.nextStringValue());
		log.info(dfmvi.nextIntValue());
		log.info(dfmvi.nextLongValue());
		
	}

}