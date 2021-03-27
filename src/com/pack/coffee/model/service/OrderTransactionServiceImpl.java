package com.pack.coffee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.coffee.model.bean.AddOn;
import com.pack.coffee.model.bean.Coffee;
import com.pack.coffee.model.bean.OrderTransaction;
import com.pack.coffee.model.dao.OrderTransactionDao;

@Service("OrderTransactionService")
public class OrderTransactionServiceImpl implements OrderTransactionService {
	@Autowired
	private OrderTransactionDao orderTran;
	@Autowired
	private CoffeeService coffServ;
	@Autowired
	private AddOnService addOnServ;
	
	public void setOrderTran(OrderTransactionDao orderTran) {
		this.orderTran = orderTran;
	}

	public void setCoffServ(CoffeeService coffServ) {
		this.coffServ = coffServ;
	}

	public void setAddOnServ(AddOnService addOnServ) {
		this.addOnServ = addOnServ;
	}

	int addOnId =0,coffeeId=0;
	@Override
	public int createOrderTran(int orderId, String coffeeName, String coffeeSize,String addOnName)
			{
		
		
		Coffee coffe = coffServ.getCoffeeByNameAndSize(coffeeName, coffeeSize);	
	
		AddOn addOn = addOnServ.getAddOnByName(addOnName);
		
		coffeeId = coffe.getCoffeeId();
		if(addOn!=null)
		addOnId =  addOn.getAddOnID();
		
	//	System.out.println(coffeeId +"|"+ addOnId);
		
		int orderTId=0;
		orderTId = orderTran.getMaxOrderTranId();
		orderTId = orderTId+1;
		//System.out.println("+++++++++++++++++++++++++++" + orderTId);
		//System.out.println("+++++++++++++++++++++++++++" + orderId);
		orderTran.createOrderTran(orderTId,orderId, coffeeId, addOnId);
		return orderId;
	}

	@Override
	public ArrayList<OrderTransaction> getOrderTranByOrderID(int orderId)   {
	
		return orderTran.getOrderTranByOrderID(orderId);
		/*
		ArrayList<OrderTransaction> orderTList = new ArrayList<OrderTransaction>();
		
		for(OrderTransaction orderlist : orderTList) {
		
				coffee = coffServ.getCoffeeDetailsById(orderlist.getCoffeeId());
				
			}
		return orderTList;
		*/
	}

	@Override
	public ArrayList<Integer> getCoffeeIdByOrderID(int orderId){
		return orderTran.getCoffeeIdByOrderID(orderId);
	}

	@Override
	public ArrayList<Integer> getAddOnIdByOrderID(int orderId) {
		return orderTran.getAddOnIdByOrderID(orderId);
	}
	
	

}
