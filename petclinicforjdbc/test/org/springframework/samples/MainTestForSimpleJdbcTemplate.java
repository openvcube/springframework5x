package org.springframework.samples;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedSingleColumnRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.samples.petclinic.Person;

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
public class MainTestForSimpleJdbcTemplate {

	private static final Log log = LogFactory.getLog(MainTestForSimpleJdbcTemplate.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = 
			new ClassPathXmlApplicationContext("simplejdbctemplate.xml");		
		
		SimpleJdbcTemplate sjt = (SimpleJdbcTemplate)cbf.getBean("simpleJdbcTemplate");
				
		List<Person> perList = sjt.query("select * from vets", 
				new ParameterizedRowMapper<Person>(){
					public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
						Person pers = new Person();
						pers.setId(rs.getInt("id"));
						pers.setFirstName(rs.getString("first_name"));
						pers.setLastName(rs.getString("last_name"));
						return pers;
					}
		});
		log.info(perList);
		 
		List<Person> vList = sjt.query("select * from vets", 
					ParameterizedBeanPropertyRowMapper.newInstance(Person.class));
		log.info(vList);
		
		List<String> firstNameList = sjt.query("select first_name from vets", 
					ParameterizedSingleColumnRowMapper.newInstance(String.class));
		log.info(firstNameList);
		
		IDaoSupport sjd = (IDaoSupport)cbf.getBean("simpleJdbcDaoSupportImpl");
		sjd.operationAll();
	}

}
