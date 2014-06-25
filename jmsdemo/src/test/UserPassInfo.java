package test;

/**
 * 
 * @author worldheart
 *
 */
public class UserPassInfo implements java.io.Serializable{

	private String username;
	
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return  "username:" + this.getUsername() + ",password:" + this.getPassword();
	}
	
}
