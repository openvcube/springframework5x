package test;

import org.springframework.util.Assert;

/**
 * 
 * @author worldheart
 * 
 */
public class TestBean4 {

	private TestBean5 testBean5;

	public TestBean4() {
		String proper = System.getProperty("dependson");
		Assert.hasText(proper);
	}

	public TestBean5 getTestBean5() {
		return testBean5;
	}

	public void setTestBean5(TestBean5 testBean5) {
		this.testBean5 = testBean5;
	}

}
