package test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author worldheart
 * 
 */
//如果是开发RMI-IIOP使能应用，则要使用javax.rmi.PortableRemoteObject
public class UserInfoImpl extends UnicastRemoteObject 
	implements IUserInfo {
	private UserPassPojo upp;

	//构建器必须抛出RemoteException
	public UserInfoImpl(UserPassPojo upp) throws RemoteException {
		this.upp = upp;
	}

	//业务方法也必须抛出RemoteException
	public String getUserInfo() throws RemoteException {
		System.out.println("客户调用到来");
		return this.upp.toString();
	}
}
