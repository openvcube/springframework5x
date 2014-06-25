package org.springframework.samples;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.samples.petclinic.Person;

/**
 * 
 * @author worldheart
 *
 */
public class MainTestForNamedParameterJdbcTemplate {

	private static final Log log = LogFactory.getLog(MainTestForNamedParameterJdbcTemplate.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("npjdbctemplate.xml");		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);
		
		NamedParameterJdbcTemplate npjt = gbfa.getBean("namedParameterJdbcTemplate");
				
		Map<String,String> map = new HashMap<String,String>();
		map.put("first_name", "Shifei");
		map.put("last_name", "Luo");
		SqlParameterSource sps = new MapSqlParameterSource(map);	

		log.info(npjt.queryForList("select address from owners where first_name = :first_name and last_name = :last_name", 
				sps));
		
		log.info(npjt.queryForList("select address from owners where first_name = :first_name and last_name = :last_name", 
				map));
		
		Person person = new Person();
		person.setFirstName("Shifei");
		person.setLastName("Luo");
		sps = new BeanPropertySqlParameterSource(person);
		
		log.info(npjt.queryForList("select address from owners where first_name = :firstName and last_name = :lastName", 
				sps));
		
		IDaoSupport npdj = gbfa.getBean("namedParameterJdbcDaoSupportImpl");
		npdj.operationAll();
	}

}
