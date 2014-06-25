package org.springframework.samples.petclinic.jdbc;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.PetType;
import org.springframework.samples.petclinic.util.EntityUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author worldheart
 *
 */
@ContextConfiguration
@TransactionConfiguration(transactionManager="tm", defaultRollback=true)
public class SimpleJdbcClinicForAbstractTransactionalJUnit38SpringContextTests 
	extends AbstractTransactionalJUnit38SpringContextTests{

	protected static final Log log = LogFactory.getLog(
			SimpleJdbcClinicForAbstractTransactionalJUnit38SpringContextTests.class);
	
	@Autowired
	private Clinic clinic;
		
	@BeforeTransaction
	public void bt() {
		log.info("before transaction");
	}
	
	@AfterTransaction
	public void at() {
		log.info("after transaction");
	}
	
	public void testFindOwnersForTest() {
		this.deleteFromTables("visits","pets","owners");
		this.executeSqlScript("org/springframework/samples/petclinic/jdbc/owners.sql", false);
		Collection owners = this.clinic.findOwners("Luo");
		assertEquals(2, owners.size());
		owners = this.clinic.findOwners("ShiFei");
		assertEquals(0, owners.size());
	}
	
	@Transactional(readOnly=true)
	public void testGetPetTypes() {
		Collection petTypes = this.clinic.getPetTypes();
		assertEquals("JDBC query must show the same number of pet typess",
				simpleJdbcTemplate.queryForInt("SELECT COUNT(0) FROM TYPES"), 
				petTypes.size());
		assertEquals("JDBC query must show the same number of pet typess",
				this.countRowsInTable("TYPES"), 
				petTypes.size());
		PetType t1 = (PetType) EntityUtils.getById(petTypes, PetType.class, 1);
		assertEquals("cat", t1.getName());
		PetType t4 = (PetType) EntityUtils.getById(petTypes, PetType.class, 4);
		assertEquals("snake", t4.getName());
	}
	
}
