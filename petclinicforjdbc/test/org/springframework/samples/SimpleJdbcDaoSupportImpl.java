package org.springframework.samples;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

/**
 * 
 * @author worldheart
 * 
 */
public class SimpleJdbcDaoSupportImpl extends
		SimpleJdbcDaoSupport implements IDaoSupport {

	protected static final Log log = LogFactory
			.getLog(SimpleJdbcDaoSupportImpl.class);

	public void operationAll() {
		log.info(this.getJdbcTemplate());

		log.info(this.getSimpleJdbcTemplate().
				queryForInt("select count(*) from owners where first_name = ? and last_name = ?"
						,"Shifei","Luo"));

		log.info(this.getSimpleJdbcTemplate().
				queryForInt(
						"select count(*) from owners where first_name = ? " +
						"and last_name = ? and telephone = ?"
						,"Shifei","Luo", "16068008"));
	}
	
}
