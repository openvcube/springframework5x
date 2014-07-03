package org.springframework.samples.petclinic.jpa;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.Owner;
import org.springframework.samples.petclinic.Pet;
import org.springframework.samples.petclinic.PetType;
import org.springframework.samples.petclinic.Vet;
import org.springframework.samples.petclinic.Visit;
import org.springframework.samples.petclinic.aspects.UsageLogAspect;
import org.springframework.samples.petclinic.util.EntityUtils;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.jpa.AbstractJpaTests;

/**
 * <p>
 * Tests for the DAO variant based on the shared EntityManager approach. Uses
 * TopLink Essentials (the reference implementation) for testing.
 * </p>
 * <p>
 * Specifically tests usage of an <code>orm.xml</code> file, loaded by the
 * persistence provider through the Spring-provided persistence unit root URL.
 * </p>
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 */
public class EntityManagerClinicTests extends AbstractJpaTests {

	protected String getConfigPath() {
		return "applicationContext-jpa.xml";
	}

	protected Clinic clinic;

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	@ExpectedException(IllegalArgumentException.class)
	public void testBogusJpql() {
		this.sharedEntityManager.createQuery("SELECT RUBBISH FROM RUBBISH HEAP").executeUpdate();
	}

	public void testApplicationManaged() {
		EntityManager appManaged = this.entityManagerFactory.createEntityManager();
		appManaged.joinTransaction();
	}

	public void testGetVets() {
		Collection<Vet> vets = this.clinic.getVets();
		// Use the inherited countRowsInTable() convenience method (from
		// AbstractTransactionalDataSourceSpringContextTests) to verify the
		// results.
		assertEquals("JDBC query must show the same number of vets", super.countRowsInTable("VETS"), vets.size());
		Vet v1 = EntityUtils.getById(vets, Vet.class, 2);
		assertEquals("Leary", v1.getLastName());
		assertEquals(1, v1.getNrOfSpecialties());
		assertEquals("radiology", (v1.getSpecialties().get(0)).getName());
		Vet v2 = EntityUtils.getById(vets, Vet.class, 3);
		assertEquals("Douglas", v2.getLastName());
		assertEquals(2, v2.getNrOfSpecialties());
		assertEquals("dentistry", (v2.getSpecialties().get(0)).getName());
		assertEquals("surgery", (v2.getSpecialties().get(1)).getName());
	}

	public void testGetPetTypes() {
		Collection<PetType> petTypes = this.clinic.getPetTypes();
		assertEquals("JDBC query must show the same number of pet types", super.countRowsInTable("TYPES"),
				petTypes.size());
		PetType t1 = EntityUtils.getById(petTypes, PetType.class, 1);
		assertEquals("cat", t1.getName());
		PetType t4 = EntityUtils.getById(petTypes, PetType.class, 4);
		assertEquals("snake", t4.getName());
	}

	public void testFindOwners() {
		Collection<Owner> owners = this.clinic.findOwners("Davis");
		assertEquals(2, owners.size());
		owners = this.clinic.findOwners("Daviss");
		assertEquals(0, owners.size());
	}

	public void testLoadOwner() {
		Owner o1 = this.clinic.loadOwner(1);
		assertTrue(o1.getLastName().startsWith("Franklin"));
		Owner o10 = this.clinic.loadOwner(10);
		assertEquals("Carlos", o10.getFirstName());

		// Check lazy loading, by ending the transaction
		endTransaction();

		// Now Owners are "disconnected" from the data store.
		// We might need to touch this collection if we switched to lazy loading
		// in mapping files, but this test would pick this up.
		o1.getPets();
	}

	public void testInsertOwner() {
		Collection<Owner> owners = this.clinic.findOwners("Schultz");
		int found = owners.size();
		Owner owner = new Owner();
		owner.setLastName("Schultz");
		this.clinic.storeOwner(owner);
		// assertTrue(!owner.isNew()); -- NOT TRUE FOR TOPLINK (before commit)
		owners = this.clinic.findOwners("Schultz");
		assertEquals(found + 1, owners.size());
	}

	public void testUpdateOwner() throws Exception {
		Owner o1 = this.clinic.loadOwner(1);
		String old = o1.getLastName();
		o1.setLastName(old + "X");
		this.clinic.storeOwner(o1);
		o1 = this.clinic.loadOwner(1);
		assertEquals(old + "X", o1.getLastName());
	}

	public void testLoadPet() {
		Collection<PetType> types = this.clinic.getPetTypes();
		Pet p7 = this.clinic.loadPet(7);
		assertTrue(p7.getName().startsWith("Samantha"));
		assertEquals(EntityUtils.getById(types, PetType.class, 1).getId(), p7.getType().getId());
		assertEquals("Jean", p7.getOwner().getFirstName());
		Pet p6 = this.clinic.loadPet(6);
		assertEquals("George", p6.getName());
		assertEquals(EntityUtils.getById(types, PetType.class, 4).getId(), p6.getType().getId());
		assertEquals("Peter", p6.getOwner().getFirstName());
	}

	public void testInsertPet() {
		Owner o6 = this.clinic.loadOwner(6);
		int found = o6.getPets().size();
		Pet pet = new Pet();
		pet.setName("bowser");
		Collection<PetType> types = this.clinic.getPetTypes();
		pet.setType(EntityUtils.getById(types, PetType.class, 2));
		pet.setBirthDate(new Date());
		o6.addPet(pet);
		assertEquals(found + 1, o6.getPets().size());
		this.clinic.storeOwner(o6);
		// assertTrue(!pet.isNew()); -- NOT TRUE FOR TOPLINK (before commit)
		o6 = this.clinic.loadOwner(6);
		assertEquals(found + 1, o6.getPets().size());
	}

	public void testUpdatePet() throws Exception {
		Pet p7 = this.clinic.loadPet(7);
		String old = p7.getName();
		p7.setName(old + "X");
		this.clinic.storePet(p7);
		p7 = this.clinic.loadPet(7);
		assertEquals(old + "X", p7.getName());
	}

	public void testInsertVisit() {
		Pet p7 = this.clinic.loadPet(7);
		int found = p7.getVisits().size();
		Visit visit = new Visit();
		p7.addVisit(visit);
		visit.setDescription("test");
		this.clinic.storePet(p7);
		// assertTrue(!visit.isNew()); -- NOT TRUE FOR TOPLINK (before commit)
		p7 = this.clinic.loadPet(7);
		assertEquals(found + 1, p7.getVisits().size());
	}
	
	private UsageLogAspect usageLogAspect;

	public void setUsageLogAspect(UsageLogAspect usageLogAspect) {
		this.usageLogAspect = usageLogAspect;
	}
	
	public void testUsageLogAspectIsInvoked() {		
		String name1 = "Schuurman";
		String name2 = "Greenwood";
		String name3 = "Leau";

		assertTrue(this.clinic.findOwners(name1).isEmpty());
		assertTrue(this.clinic.findOwners(name2).isEmpty());

		List<String> namesRequested = this.usageLogAspect.getNamesRequested();
		assertTrue(namesRequested.contains(name1));
		assertTrue(namesRequested.contains(name2));
		assertFalse(namesRequested.contains(name3));
	}

	public void testInsertOwnersVerson1() {
		Collection owners = this.clinic.findOwners("Schultz");
		int found = owners.size();
		Owner owner = new Owner();
		owner.setLastName("Schultz");
		this.clinic.storeOwnerSave(owner);
		//ΩË÷˙”⁄findOwners≤È’“Owner
		owners = this.clinic.findOwners("Schultz");
		assertEquals(found + 1, owners.size());
	}
		
	public void testInsertOwnersVerson2(){
		assertNotNull(clinic);
		this.deleteFromTables(new String[]{"visits","pets","owners"});
		Owner owner = new Owner();
		owner.setLastName("Schultz1");
		this.clinic.storeOwnerSave(owner);
		assertEquals(1, this.jdbcTemplate.queryForInt("select count(*) from owners where city = 'gz'"));
		owner = new Owner();
		owner.setLastName("Schultz2");
		this.clinic.storeOwnerSave(owner);
		assertEquals(2, this.jdbcTemplate.queryForInt("select count(*) from owners where city = 'gz'"));
		owner = new Owner();
		owner.setLastName("Schultz3");
		this.clinic.storeOwnerSave(owner);
		assertEquals(3, this.jdbcTemplate.queryForInt("select count(*) from owners where city = 'gz'"));
	}
	
}
