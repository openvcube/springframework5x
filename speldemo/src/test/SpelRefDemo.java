package test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 
 * <pre>
 * SpEL语言指引。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class SpelRefDemo {

	private static final Log log = LogFactory.getLog(SpelRefDemo.class);

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		
		double doubleValue = (Double) parser.parseExpression("3.1415E+2").getValue();
		log.info(doubleValue);
		
		int intValue = (Integer) parser.parseExpression("0x6FFF").getValue();
		log.info(intValue);
		
		boolean booleanValue = (Boolean) parser.parseExpression("false").getValue();
		log.info(booleanValue);

		Object nullValue = parser.parseExpression("null").getValue();
		log.info(nullValue);

		List strList = (List) parser.parseExpression("{'a','b','c','d'}").getValue();
		log.info(strList);

		List intList = (List) parser.parseExpression("{1,2,3,4}").getValue();
		log.info(intList);
		
		List listList = (List) parser.parseExpression("{{'a','b'},{'c','d'}}").getValue();
		log.info(listList);
		
		log.info(parser.parseExpression("'Hi,FIFA 2014!'.substring(3,12)").getValue(String.class));

		boolean trueBoolean = parser.parseExpression("6 != 8").getValue(Boolean.class);
		log.info(trueBoolean);

		trueBoolean = parser.parseExpression("6 < 8").getValue(Boolean.class);
		log.info(trueBoolean);
		
		trueBoolean = parser.parseExpression("'hello' < 'hi'").getValue(Boolean.class);
		log.info(trueBoolean);

		trueBoolean = parser.parseExpression("!('hello' instanceof T(char))").getValue(Boolean.class);
		log.info(trueBoolean);
		
		trueBoolean = parser.parseExpression("true or false").getValue(Boolean.class);
		log.info(trueBoolean);

		double dou = parser.parseExpression("6 + 8 + 6*8 - 1e2 + 8/6").getValue(Double.class);
		log.info(dou);

		log.info(parser.parseExpression("new java.lang.String('hi,FIFA 2014!')").getValue(String.class));

		log.info(parser.parseExpression("'hello' == 'hi' ? true : false").getValue(Boolean.class));
	}

}
