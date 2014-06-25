package test;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * 
 * @author worldheart
 *
 */
public class UserPassInfoConverter implements MessageConverter{
	
	public Object fromMessage(Message message) 
		throws JMSException, MessageConversionException {
		UserPassInfo upi = new UserPassInfo();
		if(message instanceof MapMessage){
			upi.setUsername(((MapMessage)message).getString("username"));
			upi.setPassword(((MapMessage)message).getString("password"));
		}
		return upi;
	}
	
	public Message toMessage(Object object, Session session) 
		throws JMSException, MessageConversionException {
		MapMessage mm = null;
		if(object instanceof UserPassInfo){
			mm = session.createMapMessage();
			mm.setString("username", ((UserPassInfo)object).getUsername());
			mm.setString("password", ((UserPassInfo)object).getPassword());
		}
		return mm;
	}
	
}
