package org.springframework.samples.jpetstore.service.client;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.jpetstore.domain.LineItem;
import org.springframework.samples.jpetstore.domain.Order;
import org.springframework.samples.jpetstore.domain.logic.OrderService;

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
public class OrderServiceHttpInvokerClient {

	protected static final Log log = LogFactory.getLog(OrderServiceHttpInvokerClient.class);
	
	protected static void printOrder(Order order) {
		log.info("Got order with order ID " + order.getOrderId() +
				" and order date " + order.getOrderDate());
		log.info("Shipping address is: " + order.getShipAddress1());
		for (Iterator lineItems = order.getLineItems().iterator(); lineItems.hasNext();) {
			LineItem lineItem = (LineItem) lineItems.next();
			log.info("LineItem " + lineItem.getLineNumber() + ": " + lineItem.getQuantity() +
					" piece(s) of item " + lineItem.getItemId());
		}
	}

	public static void main(String[] args) {
			ListableBeanFactory beanFactory = new ClassPathXmlApplicationContext("httpInvokerClientContext.xml");
			OrderService os = (OrderService)beanFactory.getBean("httpInvokerProxy");
			Order order = os.getOrder(1000);
			printOrder(order);
		}	

}
