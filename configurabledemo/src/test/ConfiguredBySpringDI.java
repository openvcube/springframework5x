package test;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.Assert;

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
@Configurable
public class ConfiguredBySpringDI {

//	public ConfiguredBySpringDI() {
//		Assert.notNull(this.infoBean);
//	}

	private InfoBean infoBean;

	public InfoBean getInfoBean() {
		return infoBean;
	}
	
	public void setInfoBean(InfoBean infoBean) {
		this.infoBean = infoBean;
	}
	
}
