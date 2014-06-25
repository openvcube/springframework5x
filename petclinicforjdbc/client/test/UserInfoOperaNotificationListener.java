package test;

import javax.management.Notification;
import javax.management.NotificationListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 * 
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
