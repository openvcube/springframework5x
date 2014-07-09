package annotest;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.samples.annotations.Owners;

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
public class HibernateTemplateOperation extends HibernateDaoSupport implements IOperation {

	private static final Log log = LogFactory.getLog(HibernateTemplateOperation.class);
	
	/* (non-Javadoc)
	 * @see annotest.IOperation#testOper()
	 */
	public void testOper(){
		log.info("testOper().......");
		
		Owners own = (Owners)this.getHibernateTemplate().execute(new HibernateCallback<Owners>(){
			public Owners doInHibernate(Session session) throws HibernateException {
				return (Owners)session.load(Owners.class, 1);
			}
		});
		
		log.info(own);		
	}
	
}
