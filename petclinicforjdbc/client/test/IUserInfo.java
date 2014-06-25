package test;

/**
 * @author worldheart
 *
 */
public interface IUserInfo {

	public String getUserName();
	
	public String getPassword();
	
	public void setUserName(String userName);
	
	public void setPassword(String password);
	
	public void updateUserInfo(String userName, String password);
	
}
