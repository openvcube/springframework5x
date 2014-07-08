package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

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
public class TaskExecutorDemo {

	protected static final Log log = LogFactory.getLog(TaskExecutorDemo.class);

	public static void main(String[] args) throws InterruptedException {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("te.xml");
		
		aac.registerShutdownHook();
		
//		TaskExecutor te = (TaskExecutor)aac.getBean("syncTaskExecutor");		
		TaskExecutor te = new SyncTaskExecutor();
		te.execute(new LogRunner());

		te = (TaskExecutor)aac.getBean("simpleAsyncTaskExecutor");
		te.execute(new LogRunner());

		te = (TaskExecutor)aac.getBean("threadPoolTaskExecutor");
		te.execute(new LogRunner());		
		
		te = (TaskExecutor)aac.getBean("concurrentTaskExecutor");
		te.execute(new LogRunner());
		
		te = (TaskExecutor)aac.getBean("simpleThreadPoolTaskExecutor");
		te.execute(new LogRunner());						
		
		te = (TaskExecutor)aac.getBean("timerTaskExecutor");
		te.execute(new LogRunner());
		
		Thread.sleep(2000);
		System.exit(0);
		
	}

}
