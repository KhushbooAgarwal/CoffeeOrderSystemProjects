package com.pack.coffee.model.dao;

import com.pack.coffee.model.bean.Customers;


public interface CustomerDao {

	int addCustomer(int custId,String custName,long phoneNum);
	Customers getCustomerByPhone(long phoneNum);
	int getMaxCustomer();
	int checkCustomer(long phoneNum) ;
	Customers getCustomerId(String custName,long phoneNum);
	String getCustomerName(int custId) ;
}
