package test;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class ConfiguredBySpringDI {

	private InfoBean infoBean;

	public InfoBean getInfoBean() {
		return infoBean;
	}
	
	public void setInfoBean(InfoBean infoBean) {
		this.infoBean = infoBean;
	}
	
}
