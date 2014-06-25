package test;

/**
 * 
 * @author worldheart
 *
 */
public class UserPassPojo {

	private String username;	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "用户信息[username:" + this.username + ",password:" + this.password + "]";
	}
	
}
