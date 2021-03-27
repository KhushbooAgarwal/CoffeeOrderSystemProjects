package com.pack.coffee.model.dao;

import java.util.ArrayList;

import com.pack.coffee.model.bean.OrderTransaction;


public interface OrderTransactionDao {
	
	int createOrderTran(int orderTranId ,int orderId,int coffeeId,int addOnID);
	ArrayList<OrderTransaction> getOrderTranByOrderID(int orderId);
	public int getMaxOrderTranId() ;
	public ArrayList<Integer> getCoffeeIdByOrderID(int orderId) ;
	public ArrayList<Integer> getAddOnIdByOrderID(int orderId) ;
}
