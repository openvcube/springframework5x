package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author worldheart
 * 
 */
public class TestBeanForFine {

	protected static final Log log = LogFactory.getLog(TestBeanForFine.class);

	@Autowired
	@FineQualifier(keyFine="key2A", valueFine="value2A")
	private TestBean2 testBean2a;

	@Autowired
	@FineQualifier(keyFine="key2B", valueFine="value2B")
	private TestBean2 testBean2b;

	@Autowired
	@FineQualifier(keyFine="key2C", valueFine="value2C")
	private TestBean2 testBean2c;

//	@Autowired
//	private void preparedBean(@Qualifier("2a") TestBean2 testBean2a, 
//			@Qualifier("2b") TestBean2 testBean2b,
//			@Qualifier("2c") TestBean2 testBean2c) {
//		this.testBean2a = testBean2a;
//		this.testBean2b = testBean2b;
//		this.testBean2c = testBean2c;
//	}

	public void beanInfo() {
		if (testBean2a != null) {
			log.info(testBean2a.getName());
		}
		if (testBean2b != null) {
			log.info(testBean2b.getName());
		}
		if (testBean2c != null) {
			log.info(testBean2c.getName());
		}
	}

}
