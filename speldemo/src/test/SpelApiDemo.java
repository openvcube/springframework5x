package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * 
 * <pre>
 * 演示SpEL接口的使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class SpelApiDemo {

	private static final Log log = LogFactory.getLog(SpelApiDemo.class);

	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		//评估字符串
		Expression exp = parser.parseExpression("'worldheart'");
		String valueStr = (String)exp.getValue(); 
		log.info(valueStr);

		//字符串运算
		exp = parser.parseExpression("'hi,'.concat('worldheart').toUpperCase()");
		valueStr = (String)exp.getValue(); 
		log.info(valueStr);
		
		//数学运算
		valueStr = parser.parseExpression(
		        "-100对应的绝对值是， #{T(java.lang.Math).abs(-100)}",
		        new TemplateParserContext()).getValue(String.class);
		log.info(valueStr);
		
		//评估字符串长度
		exp = parser.parseExpression("'worldheart'.bytes.length");
		int valueLength = (Integer) exp.getValue();
		log.info(valueLength);
	}

}
