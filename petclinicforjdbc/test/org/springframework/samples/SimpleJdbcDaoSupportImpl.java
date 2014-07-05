package org.springframework.samples;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

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
public class SimpleJdbcDaoSupportImpl extends
		SimpleJdbcDaoSupport implements IDaoSupport {

	private static final Log log = LogFactory
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
