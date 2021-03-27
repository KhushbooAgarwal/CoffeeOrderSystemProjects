package com.pack.coffee.model.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.coffee.model.bean.Orders;
import com.pack.coffee.model.dao.OrderDao;
import com.pack.coffee.model.dao.OrderTransactionDao;

import java.sql.SQLException;
import java.util.ArrayList;


@Service("OrderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderTransactionDao orderTDao;
    

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public void setOrderTDao(OrderTransactionDao orderTDao) {
		this.orderTDao = orderTDao;
	}
	@Override
	public Orders getOrderByCustid(int customerId)  {
		return orderDao.getOrderByCustid(customerId);	
		
	}
	@Override
	public int CreateOrder(int customerId, String orderDate, int voucherId)
			 {		
		
			int orderId=0;
			orderId = orderDao.getMaxOrderId();
			orderId = orderId+1;
			orderDao.CreateOrder(orderId,customerId, orderDate, voucherId);	
		
		return orderId;
	}

}
