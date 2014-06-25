package test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author worldheart
 * 
 */
public class TestBean1 {

	@Autowired
	private TestBean2 testBean2;

	@Autowired
	private TestBean3 testBean3;
		
	public TestBean1() {
	}

	public TestBean1(TestBean2 tb2, TestBean3 tb3) {
		this.testBean2 = tb2;
		this.testBean3 = tb3;
	}

	public TestBean2 getTestBean2() {
		return testBean2;
	}
	
	public void setTestBean2(TestBean2 testBean2) {
		this.testBean2 = testBean2;
	}

	public TestBean3 getTestBean3() {
		return testBean3;
	}
	
	public void setTestBean3(TestBean3 testBean3) {
		this.testBean3 = testBean3;
	}

	public void preparedBean(TestBean2 tb2, TestBean3 tb3){
		this.testBean2 = tb2;
		this.testBean3 = tb3;
	}
	
}
