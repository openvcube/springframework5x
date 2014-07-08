package test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.springframework.samples.Owners;
import org.springframework.samples.Pets;
import org.springframework.samples.Specialties;
import org.springframework.samples.Types;
import org.springframework.samples.Vets;
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
public class MainTestForHibernateDemo {

	private static final Log log = LogFactory
			.getLog(MainTestForHibernateDemo.class);

	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public static void main(String[] args) {

		//提供.hbm/.class信息
		Configuration cfg = new Configuration().addClass(Owners.class)
				.addClass(Pets.class).addClass(Types.class)
				.addClass(Vets.class).addClass(Specialties.class)
				.addClass(Visits.class);

		MainTestForHibernateDemo mthd = new MainTestForHibernateDemo();
		//使用classpath根路径的hibernate.cfg.xml。如果不调用它，则默认会使用hibernate.properties
		cfg.configure();
		//构建线程安全的SessionFactory
		mthd.setSf(cfg.buildSessionFactory());

		mthd.testVisitsVersionHQL();
		mthd.testVisitsVersionCriteriaAPI();
		mthd.testVisitsVersionNativeSQL();

		mthd.sf.close();

	}

	public void testVisitsVersionHQL() {
		//获得线程不安全的Hibernate Session
		Session session = this.sf.openSession();
		Transaction tran = null;
		try {
			//手工管理事务
			tran = session.beginTransaction();
			//借助于HQL查询数据
			List list = session.createQuery("from Visits vi").setFirstResult(1).setMaxResults(3).list();
			//直接分析由Visits构成的集合
			for (Object visits : list) {
				Visits visit = (Visits) visits;
				log.info("id:" + visit.getId() + ",visitDate:" + visit.getVisitDate() +
						",description:" + visit.getDescription() + ",pets:" + visit.getPets() );
			}
			tran.commit();
		} catch (Exception exe) {
			if (tran != null)
				tran.rollback();
			log.error("", exe);
		} finally {
			session.close();
		}
	}
	
	public void testVisitsVersionCriteriaAPI() {
		//获得线程不安全的Hibernate Session
		Session session = this.sf.openSession();
		Transaction tran = null;
		try {
			//手工管理事务
			tran = session.beginTransaction();
			//借助于Criteria API查询数据
			List list = session.createCriteria(Visits.class).setFirstResult(1).setMaxResults(3).addOrder(Order.asc("visitDate")).list();
			//直接分析由Visits构成的集合
			for (Object visits : list) {
				Visits visit = (Visits) visits;
				log.info("id:" + visit.getId() + ",visitDate:" + visit.getVisitDate() +
						",description:" + visit.getDescription() + ",pets:" + visit.getPets() );
			}
			tran.commit();
		} catch (Exception exe) {
			if (tran != null)
				tran.rollback();
			log.error("", exe);
		} finally {
			session.close();
		}
	}
	
	public void testVisitsVersionNativeSQL() {
		//获得线程不安全的Hibernate Session
		Session session = this.sf.openSession();
		Transaction tran = null;
		try {
			//手工管理事务
			tran = session.beginTransaction();
			//借助于原生SQL语句查询数据
			List list = session.createSQLQuery("select id,visit_date from Visits").setFirstResult(1).setMaxResults(3).list();
			//直接分析由数组构成的集合
			for (Object visits : list){
				Object[] vi = (Object[])visits;
				log.info("id:"+vi[0] + ",visit_date:" + vi[1]);
			}				
			//完成查询结果到Hibernate实体的映射
			list = session.createSQLQuery("select * from Visits").addEntity(Visits.class).setFirstResult(1).setMaxResults(3).list();
			//	直接分析由Visits构成的集合
			for (Object visits : list){
				Visits visit = (Visits) visits;
				log.info("id:" + visit.getId() + ",visitDate:" + visit.getVisitDate());
			}							
			tran.commit();
		} catch (Exception exe) {
			if (tran != null)
				tran.rollback();
			log.error("", exe);
		} finally {
			session.close();
		}
	}

}
