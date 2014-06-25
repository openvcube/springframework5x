package test;

import org.springframework.beans.factory.BeanNameAware;

/**
 * 
 * @author worldheart
 * 
 */
public class TestBean2 implements BeanNameAware{

	private String name;
	
	public void setBeanName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
