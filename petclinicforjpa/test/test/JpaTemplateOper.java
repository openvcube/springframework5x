package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

import test.entityjpa.Owners;

/**
 * 
 * @author worldheart
 * 
 */
public class JpaTemplateOper extends JpaDaoSupport implements IOper {
	
	protected static final Log log = LogFactory.getLog(JpaTemplateOper.class);

	public void testOper() {
		Owners own = this.getJpaTemplate().find(Owners.class, 1);
		printResult(own);

		List list1 = this.getJpaTemplate().find(
				"from Owners own where own.lastName like 'E%'");
		printResult(list1);

		List list2 = this.getJpaTemplate().find(
				"from Owners own where own.lastName like ?1", "E%");
		printResult(list2);

		Map<String, String> map = new HashMap<String, String>();
		map.put("lastName", "E%");
		
		List list3 = this.getJpaTemplate().findByNamedParams(
				"from Owners own where own.lastName like :lastName", map);
		printResult(list3);

		List list4 = this.getJpaTemplate().findByNamedQueryAndNamedParams("findOwnersByLastName", map);
		printResult(list4);

		List list5 = this.getJpaTemplate().executeFind(new JpaCallback(){
			public Object doInJpa(EntityManager em) throws PersistenceException {
				return em.createNativeQuery("select * from Owners own where own.last_name like ?1",
				"getOwners").setParameter(1, "E%").getResultList();
			}
		});  		
		printResult(list5);

		List list6 = this.getJpaTemplate().executeFind(new JpaCallback(){
			public Object doInJpa(EntityManager em) throws PersistenceException {
				return em.createNativeQuery("select * from Owners own where own.last_name like ?1",
						Owners.class).setParameter(1, "E%").getResultList();
			}
		});  		
		printResult(list6);
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
	
	public void storeOwnerSave(Owners owner) throws DataAccessException{
		this.getJpaTemplate().persist(owner);
		owner.setCity("gz");
	}

	public Collection findOwners(String lastName) throws DataAccessException {
		Map<String,String> map = new HashMap<String, String>();
		map.put("lastName", lastName + "%");
		return this.getJpaTemplate()
			.findByNamedParams("SELECT owner FROM Owners owner WHERE owner.lastName LIKE :lastName", map);
	}
	
}
