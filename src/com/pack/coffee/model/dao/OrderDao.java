package com.pack.coffee.model.dao;


import com.pack.coffee.model.bean.Orders;


public interface OrderDao {
	
	int CreateOrder(int orderId,int customerId,String orderDate,int voucherId);
	Orders getOrderByCustid(int customerId);
	public int getMaxOrderId();
	public boolean isOrderIsPresent(int orderId);
}
