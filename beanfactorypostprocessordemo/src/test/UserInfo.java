package test;

/**
 * 实现了ITestBean接口
 * 
 * @author worldheart
 * 
 */
public class UserInfo implements IUserInfo {

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

	public String getUserInfo() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getUsername()).append("->").append(this.getPassword());
		return sb.toString();
	}

}
