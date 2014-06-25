package org.springframework.samples.petclinic.hibernate;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

/**
 * 
 * Title:辅助集成测试，Spring AOP拦截器。
 * Description: 保证在进入目标测试方法前，能够将Hibernate Session中的HQL同步到RDBMS。
 *    如果目标测试方法中使用到JDBC，则这一拦截器必不可少
 * 
 */
public class HibernateFlushBeforeInterceptor implements MethodInterceptor {

    protected static final Log log = LogFactory.getLog(HibernateFlushBeforeInterceptor.class);

    // 注入Hibernate 3.x SessionFactory
    private SessionFactory sessionFactory;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("Entering HibernateFlushBeforeInterceptor()...." + invocation.getClass());
        //确保flush()方法在业务方法被调用前触发
        Session session = SessionFactoryUtils.getSession(this.sessionFactory, false);
        if (session != null) {
            log.info("Running session.flush()");
            session.flush();
        }
        //拦截链继续
        Object object = invocation.proceed();
        log.info("Exiting HibernateFlushBeforeInterceptor()...." + invocation.getClass());
        return object;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
