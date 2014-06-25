package org.springframework.samples;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * 
 * @author worldheart
 * 
 */
public class JdbcDaoSupportImpl extends
		JdbcDaoSupport implements IDaoSupport {

	protected static final Log log = LogFactory
			.getLog(JdbcDaoSupportImpl.class);

	public void operationAll() {
		log.info(this.getJdbcTemplate());

		log.info(this.getJdbcTemplate().
				queryForMap("select count(*) from owners where first_name = ? and last_name = ?"
						,new Object[]{"Shifei","Luo"}));

		log.info(this.getJdbcTemplate().
				queryForMap(
						"select count(*) from owners where first_name = ? " +
						"and last_name = ? and telephone = ?"
						,new Object[]{"Shifei","Luo", "16068008"}));
	}
	
}
