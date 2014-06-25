package test;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 * 
 */
public class RmiServer {
	protected static final Log log = LogFactory.getLog(RmiServer.class);

	public static void main(String args[]) {
		try {
			UserPassPojo upp = new UserPassPojo();
			upp.setUsername("spring");
			upp.setPassword("dragon");
			IUserInfo ui = new UserInfoImpl(upp);			
			Context ic = new InitialContext();
			ic.rebind("rmi:userinfo", ui);
		} catch (NamingException ne) {
			log.error("", ne);
		} catch(RemoteException re){
			log.error("", re);
		}
	}
}
