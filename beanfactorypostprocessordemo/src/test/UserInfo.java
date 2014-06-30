package test;

/**
 * 
 * <pre>
 * 实现了IUserInfo接口。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
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
