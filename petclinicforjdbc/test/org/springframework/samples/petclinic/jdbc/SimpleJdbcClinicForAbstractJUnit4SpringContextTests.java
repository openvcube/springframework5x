/**
 * Copyright(c) http://www.open-v.com
 */
package org.springframework.samples.petclinic.jdbc;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

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
@ContextConfiguration
public class SimpleJdbcClinicForAbstractJUnit4SpringContextTests 
	extends AbstractJUnit4SpringContextTests{

	private static final Log log = LogFactory.getLog(
			SimpleJdbcClinicForAbstractJUnit4SpringContextTests.class);
	
	@Autowired
	private Clinic clinic;
	
	@Test
	public void testXxx() {
		assertNotNull(this.clinic);		
		log.info(this.clinic);
	}

}
