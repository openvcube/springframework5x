package test;

import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class TestBean1 {

	@Value("#{systemProperties['file.encoding']}")
	private String userName;
	
	private boolean validFlag;
	
	/**
	 * @param userName 设置 userName。
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return 返回 userName。
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @return 返回 validFlag。
	 */
	public boolean isValidFlag() {
		return validFlag;
	}
	
	/**
	 * @param validFlag 设置 validFlag。
	 */
	public void setValidFlag(boolean validFlag) {
		this.validFlag = validFlag;
	}
	
}
