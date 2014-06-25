package org.springframework.samples.jpetstore.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.jpetstore.domain.Order;
import org.springframework.samples.jpetstore.domain.logic.OrderService;

/**
 * 
 * @author Administrator
 *
 */
@WebService(serviceName="OrderService")
public class JaxWsOrderService implements OrderService{

	@Autowired
	private OrderService orderService;
	
	@WebMethod
	public Order getOrder(int orderId) {
		return this.orderService.getOrder(orderId);
	}

}
