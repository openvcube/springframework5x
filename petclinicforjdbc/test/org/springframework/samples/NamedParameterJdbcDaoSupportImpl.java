package org.springframework.samples;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
public class NamedParameterJdbcDaoSupportImpl extends
		NamedParameterJdbcDaoSupport implements IDaoSupport {

	private static final Log log = LogFactory
			.getLog(NamedParameterJdbcDaoSupportImpl.class);

	public void operationAll() {
		log.info(this.getJdbcTemplate());

		Person person = new Person();
		person.setFirstName("Shifei");
		person.setLastName("Luo");
		SqlParameterSource sps = new BeanPropertySqlParameterSource(person);

		log.info(this.getNamedParameterJdbcTemplate().queryForInt("select count(*) from owners where first_name = :firstName and last_name = :lastName", 
					sps));
	}

}
