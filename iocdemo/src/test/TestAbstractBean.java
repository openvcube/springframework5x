package test;

/**
 * 验证抽象Bean和子Bean
 * 
 * @author worldheart
 * 
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
