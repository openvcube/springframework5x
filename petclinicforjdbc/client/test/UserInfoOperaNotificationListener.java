package test;

import javax.management.Notification;
import javax.management.NotificationListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
public class UserInfoOperaNotificationListener implements NotificationListener {

	protected static final Log log = LogFactory
			.getLog(UserInfoOperaNotificationListener.class);

	public void handleNotification(Notification notification, Object handback) {
		log.info(notification.getUserData());
		log.info(notification);
		log.info(handback);
	}

}
