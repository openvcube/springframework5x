package test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.SpringVersion;
import org.springframework.core.io.ResourceLoader;

/**
 * 
 * <pre>
 * 实现了许多回调接口。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class TestBean implements ITestBean, BeanNameAware,
	BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware,
	ApplicationEventPublisherAware, MessageSourceAware,
	ApplicationContextAware, InitializingBean, DisposableBean  {

	private static final Log log = LogFactory.getLog(TestBean.class);
	
	private String beanName;
	
	private ClassLoader classLoader;
	
	private BeanFactory bf;
	
	private ResourceLoader resourceLoader;
	
	private ApplicationEventPublisher applicationEventPublisher;
	
	private MessageSource messageSource;
	
	private ApplicationContext applicationContext;
	
	public void setBeanName(String name) {
		log.info("调用setBeanName");
		this.beanName = name;
	}

	public void setBeanClassLoader(ClassLoader classLoader) {
		log.info("调用setBeanClassLoader");
		this.classLoader = classLoader;
	}
	
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		log.info("调用setBeanFactory");
		this.bf = beanFactory;
	}
	
	public void setResourceLoader(ResourceLoader resourceLoader) {
		log.info("调用setResourceLoader");
		this.resourceLoader = resourceLoader;
	}
	
	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {
		log.info("调用setApplicationEventPublisher");
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public void setMessageSource(MessageSource messageSource) {
		log.info("调用setMessageSource");
		this.messageSource = messageSource;
	}
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		log.info("调用setApplicationContext");
		this.applicationContext = applicationContext;
	}
	
	public String testBean() {
		return SpringVersion.getVersion();
	}
	
	@PostConstruct
	public void postConstruct(){
		log.info("调用postConstruct");
	}
	
	@PreDestroy
	public void preDestroy(){
		log.info("调用preDestroy");
	}
	
	public void afterPropertiesSet() throws Exception {
		log.info("调用afterPropertiesSet");
	}
	
	public void destroy() throws Exception {
		log.info("调用destroy");
	}
	
	//供定义init-method使用
	public void start(){
		log.info("调用<bean/>定义的init-method方法start");
	}
	
	//供定义destroy-method使用
	public void finish(){
		log.info("调用<bean/>定义的destroy-method方法finish");
	}
	
}
