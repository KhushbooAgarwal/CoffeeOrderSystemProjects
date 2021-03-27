package com.pack.coffee.model.service;

import java.util.ArrayList;

import com.pack.coffee.model.bean.OrderTransaction;



public interface OrderTransactionService {
	
	int createOrderTran(int orderId,String coffeeName, String coffeeSize,String addOn);
	ArrayList<OrderTransaction> getOrderTranByOrderID(int orderId);
	public ArrayList<Integer> getCoffeeIdByOrderID(int orderId);
	public ArrayList<Integer> getAddOnIdByOrderID(int orderId);
}

