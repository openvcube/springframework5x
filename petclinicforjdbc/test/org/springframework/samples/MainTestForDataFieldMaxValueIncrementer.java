package org.springframework.samples;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

/**
 * 
 * @author worldheart
 *
 */
public class MainTestForDataFieldMaxValueIncrementer {

	private static final Log log = LogFactory.getLog(MainTestForDataFieldMaxValueIncrementer.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("jdbctemplate.xml");		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);
		
		DataSource ds = gbfa.getBean("dataSource");
		
		DataFieldMaxValueIncrementer dfmvi = 
			new OracleSequenceMaxValueIncrementer(ds, "HIBERNATE_SEQUENCE");
		log.info(dfmvi.nextStringValue());
		log.info(dfmvi.nextIntValue());
		log.info(dfmvi.nextLongValue());
		
	}

}