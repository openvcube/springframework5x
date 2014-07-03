package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.entityjpa.Owners;

/**
 * 
 * @author worldheart
 * 
 */
@Transactional
@Repository
public class JpaInfoImpl{

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}
	
	protected static final Log log = LogFactory.getLog(JpaInfoImpl.class);

	public void testOper() {
		Owners own = em.find(Owners.class, 1);		
		printResult(own);
		
		List list1 = em.createQuery("from Owners own where own.lastName like 'E%'").getResultList();
		printResult(list1);
		
		List list2 = em.createQuery("from Owners own where own.lastName like ?1").setParameter(1, "E%") .getResultList();		
		printResult(list2);
		
		List list3 = em.createQuery("from Owners own where own.lastName like :lastName").setParameter("lastName", "E%") .getResultList();		
		printResult(list3);
		
		List list4 = em.createNamedQuery("findOwnersByLastName").setParameter("lastName", "E%").getResultList();
		printResult(list4);
		
		List list5 = em.createNativeQuery("select * from Owners own where own.last_name like ?1", "getOwners").setParameter(1, "E%").getResultList();
		printResult(list5);
		
		List list6 = em.createNativeQuery("select * from Owners own where own.last_name like ?1", Owners.class).setParameter(1, "E%").getResultList();
		printResult(list6);
		
		this.printEmf();
	}
	
	private void printEmf(){
		log.info(this.emf);
	}

	public static void printResult(Object obj) {
		if (obj instanceof List) {
			for (Object owners : (List) obj) {
				Owners own = (Owners) owners;
				printOwners(own);
			}
		} else {
			Owners own = (Owners) obj;
			printOwners(own);
		}
	}

	public static void printOwners(Owners own) {
		log.info("id:" + own.getId() + ",address:" + own.getAddress()
				+ ",first_name:" + own.getFirstName() + ",last_name:"
				+ own.getLastName() + ",telephone:" + own.getTelephone()
				+ ",city:" + own.getCity() + ",pets:" + own.getPetses());
	}

}
