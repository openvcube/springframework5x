package annotest;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.samples.annotations.Owners;

/**
 * 
 * @author worldheart
 *
 */
public class HibernateTemplateOperation extends HibernateDaoSupport implements IOperation {

	protected static final Log log = LogFactory.getLog(HibernateTemplateOperation.class);
	
	/* (non-Javadoc)
	 * @see annotest.IOperation#testOper()
	 */
	public void testOper(){
		log.info("testOper().......");
		
		Owners own = (Owners)this.getHibernateTemplate().execute(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return session.load(Owners.class, 1);
			}
		});
		
		log.info(own);
		
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				return session.createQuery("from org.springframework.samples.annotations.Owners").list();
			}
		});
		
		log.info(list);
		
				
	}
	
}
