package test;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.samples.Owners;
import org.springframework.samples.Visits;

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
public class HibernateTemplateOper extends HibernateDaoSupport implements IOper {

	private static final Log log = LogFactory.getLog(HibernateTemplateOper.class);
	
	/* (non-Javadoc)
	 * @see test.IOper#testOper()
	 */
	public void testOper(){
		log.info("testOper().......");
				
		Owners own1 = (Owners)this.getHibernateTemplate().get(Owners.class, 1);
		Owners own2 = (Owners)this.getHibernateTemplate().load(Owners.class, 1);
		this.getHibernateTemplate().refresh(own1);
		this.getHibernateTemplate().refresh(own2);
		
		List list1 = this.getHibernateTemplate().findByNamedQuery("namedVisits", 2);
		log.info(list1);
		
		List list2 = this.getHibernateTemplate().
			findByNamedQueryAndNamedParam("namedAndParamedVisits", new String[]{"id"}, new Object[]{2});
		log.info(list2);
		
		DetachedCriteria dc = DetachedCriteria.forEntityName("org.springframework.samples.Visits")
			.add(Property.forName("id").eq(2));
		List  dcList1 = this.getHibernateTemplate().findByCriteria(dc);
		log.info(dcList1);
		
		Visits visits = new Visits();

		List exaList = this.getHibernateTemplate().findByExample(visits,1,2);
		for(Object visit: exaList){
			Visits vis = (Visits)visit;
			log.info("id:" + vis.getId() + ",visitDate:" + vis.getVisitDate() + ",description:" + 
					vis.getDescription() + ",pets:" + vis.getPets());
		}
		
		Iterator iterator = this.getHibernateTemplate().iterate("from Visits vi where vi.id = ?", new Object[]{2});
		while(iterator.hasNext()){
			Visits vis = (Visits)iterator.next();
			log.info("id:" + vis.getId() + ",visitDate:" + vis.getVisitDate() + ",description:" + 
					vis.getDescription() + ",pets:" + vis.getPets());
		}
		//关闭迭代器
		this.getHibernateTemplate().closeIterator(iterator);
		
		int updatedRows = this.getHibernateTemplate()
			.bulkUpdate("update Owners set telephone = '10000000' where lastName = ?", "Davis" );
		log.info(updatedRows);
				
		Owners own = (Owners)this.getHibernateTemplate().execute(new HibernateCallback<Owners>(){
			public Owners doInHibernate(Session session) throws HibernateException {
				return (Owners)session.load(Owners.class, 1);
			}
		});
		
		log.info(own);
	}
	
}
