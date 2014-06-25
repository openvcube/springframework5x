package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

/**
 * 
 * @author worldheart
 * 
 */
public class TaskExecutorDemo {

	protected static final Log log = LogFactory.getLog(TaskExecutorDemo.class);

	public static void main(String[] args) throws InterruptedException {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("te.xml");
		
		aac.registerShutdownHook();
		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(aac);
				
//		TaskExecutor te = gbfa.getBean("syncTaskExecutor");		
		TaskExecutor te = new SyncTaskExecutor();
		te.execute(new LogRunner());

		te = gbfa.getBean("simpleAsyncTaskExecutor");
		te.execute(new LogRunner());

		te = gbfa.getBean("threadPoolTaskExecutor");
		te.execute(new LogRunner());		
		
		te = gbfa.getBean("concurrentTaskExecutor");
		te.execute(new LogRunner());
		
		te = gbfa.getBean("simpleThreadPoolTaskExecutor");
		te.execute(new LogRunner());						
		
		te = gbfa.getBean("timerTaskExecutor");
		te.execute(new LogRunner());
				
		Thread.sleep(2000);
		System.exit(0);
		
	}

}