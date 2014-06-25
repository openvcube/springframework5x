package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.task.TaskExecutor;

/**
 * 
 * @author Administrator
 * 
 */
public class RarLoggingBean {

	private static final Log log = LogFactory.getLog(RarLoggingBean.class);

	private TaskExecutor taskExecutor;

	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public RarLoggingBean() {
		log.info(this);
	}

	public void loggingTime() {
		this.taskExecutor.execute(new LogRunner());
	}

}
