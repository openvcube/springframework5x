package org.springframework.samples.petclinic.jdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.test.AbstractSingleSpringContextTests;

/**
 * 
 * @author worldheart
 *
 */
public class JdbcClinicTestsForAbstractSingleSpringContextTests extends AbstractSingleSpringContextTests{

	protected static final Log log = LogFactory.getLog(JdbcClinicTestsForAbstractSingleSpringContextTests.class);
	
	protected Clinic clinic;

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	protected void onSetUp() throws Exception {
		log.info("onSetUp()");
	}

	protected void onTearDown() throws Exception {
		log.info("onTearDown()");
	}
	
	public void testXxx() {				
		assertEquals(null, this.clinic);
		log.info(this.applicationContext.getStartupDate());
		log.info(this.applicationContext.getBean("clinic"));
		this.setDirty();		
	}

	public void testYyy() {
		log.info(this.applicationContext.getStartupDate());
		assertEquals(null, this.clinic);
		log.info(this.applicationContext.getBean("clinic"));
	}
			
	protected String[] getConfigLocations() {
		return new String[] { "/org/springframework/samples/petclinic/jdbc/applicationContext-jdbc.xml" };
	}

}
