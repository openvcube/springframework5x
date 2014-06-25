package org.springframework.samples.petclinic.jdbc;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.test.annotation.AbstractAnnotationAwareTransactionalTests;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.NotTransactional;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.annotation.Timed;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author worldheart
 * 
 */
public class JdbcClinicTestsForAbstractAnnotationAwareTransactionalTests extends
		AbstractAnnotationAwareTransactionalTests {

	protected static final Log log = LogFactory
			.getLog(JdbcClinicTestsForAbstractAnnotationAwareTransactionalTests.class);

	private Clinic clinic;

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	@Timed(millis=1500)
	public void testFindOwnersForTestA() {
		this.deleteFromTables(new String[]{"visits","pets","owners"});
		this.simpleJdbcTemplate.update(
				"insert into owners values(13,'Shifei','Luo','GuangZhou','guangzhou','16068008')");
		Collection owners = this.clinic.findOwners("Luo");
		assertEquals(1, owners.size());
	}

	@Repeat(2)
	@DirtiesContext
	public void testFindOwnersForTestB() {
		this.deleteFromTables(new String[]{"visits","pets","owners"});
		this.jdbcTemplate.execute(
				"insert into owners values(13,'Shifei','Luo','GuangZhou','guangzhou','16068008')");
		Collection owners = this.clinic.findOwners("Luo");
		assertEquals(1, owners.size());
	}
	
	@ExpectedException(RuntimeException.class)
	public void testFindOwnersForTestC() {
		this.deleteFromTables(new String[]{"visits","pets","owners"});
		this.jdbcTemplate.execute(
				"insert into owners values(13,'Shifei','Luo','GuangZhou','guangzhou','16068008')");
		Collection owners = this.clinic.findOwners("Luo");
		assertEquals(1, owners.size());
		throw new RuntimeException();
	}
	
	@Transactional(readOnly=true)
	public void testFindOwnersForTestD() {
		log.info("testFindOwnersForTestD");
	}
	
	@NotTransactional
	public void testFindOwnersForTestE() {
		log.info("testFindOwnersForTestE");
	}

	@Rollback(false)
	public void testFindOwnersForTestF() {
		log.info("testFindOwnersForTestF");
	}

	@IfProfileValue(name="os.name", value="Windows 2003")
	public void testFindOwnersForTestG() {
		log.info("testFindOwnersForTestG");
	}

	protected String[] getConfigLocations() {
		return new String[] { "/org/springframework/samples/petclinic/jdbc/applicationContext-jdbc.xml" };
	}

}
