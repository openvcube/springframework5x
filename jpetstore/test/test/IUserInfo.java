package test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author worldheart
 * 
 */
//继承Remote接口，以支持RMI语义
public interface IUserInfo extends Remote {

	//抛出RemoteException，以支持RMI语义
	String getUserInfo() throws RemoteException;

}
