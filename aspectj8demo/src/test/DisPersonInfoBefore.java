package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
public class DisPersonInfoBefore implements IDisPersonInfo {

	private int ij;
	
	private static final Log log = LogFactory.getLog(DisPersonInfoBefore.class);

	public void setIj(int ij) {
		this.ij = ij;
	}
	
	public int getIj() {
		return ij;
	}
	
	public void compute(String person) {
		log.info(person);
	}

	public void compute(String person, int age) {
		age+=ij;
		log.info(person + "已经" + age + "岁了！");
	}

	public void setVar(int i){
		this.setIj(i);
	}
}
