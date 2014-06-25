package test;

/**
 * @author worldheart
 * 
 */
public class UserInfoPojo implements IUserName, IPassword {

	private String userName;	
	private String password;
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void updateUserInfo(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String toString() {
		return "userName:" + this.userName + ", password:" + this.password;
	}
	
}
