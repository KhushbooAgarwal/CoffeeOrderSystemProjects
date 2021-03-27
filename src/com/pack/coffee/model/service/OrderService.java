package com.pack.coffee.model.service;

import com.pack.coffee.model.bean.Orders;
public interface OrderService {
	
	int CreateOrder(int customerId,String orderDate,int voucherId);
	Orders getOrderByCustid(int customerId);

}
