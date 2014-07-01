package test;

/**
 * 
 * <pre>
 * 验证抽象Bean和子Bean。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class TestAbstractBean {

	private String username;

	private String password;

	private String sex;

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		return sb.append("用户名：").append(this.getUsername()).append("-密码：")
				.append(this.getPassword()).append("-性别：").append(this.getSex())
				.toString();
	}

}
