package org.springframework.samples;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

/**
 * 
 * @author worldheart
 * 
 */
public class MainTestForSimpleJdbcInsert {

	private static final Log log = LogFactory
			.getLog(MainTestForSimpleJdbcInsert.class);

	public static void main(String[] args) {
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext(
				"simplejdbcinsert.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);

		DataSource dataSource = gbfa.getBean("dataSource");

		SimpleJdbcInsert ownerInsert = new SimpleJdbcInsert(dataSource);
		ownerInsert.withTableName("owners");

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", 81);
		param.put("first_name", "Need");
		param.put("last_name", "Want");

		ownerInsert.execute(param);

		ownerInsert = new SimpleJdbcInsert(dataSource).withTableName("owners")
				.usingGeneratedKeyColumns("id");

		param = new HashMap<String, Object>();
		param.put("first_name", "Need");
		param.put("last_name", "Want");

		log.info(ownerInsert.executeAndReturnKeyHolder(param));

		ownerInsert = new SimpleJdbcInsert(dataSource).withTableName("owners")
				.usingGeneratedKeyColumns("id").usingColumns("first_name", "last_name");

		param = new HashMap<String, Object>();
		param.put("first_name", "Need");
		param.put("last_name", "Want");

		ownerInsert.execute(param);

	}

}
