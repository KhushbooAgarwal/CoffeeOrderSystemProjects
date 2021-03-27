package com.pack.coffee.model.service;


import com.pack.coffee.model.bean.Customers;


public interface CustomerService {

	int addCustomer(String custName, long phoneNum);
	Customers getCustomerByPhone(long phoneNum) ;
	int checkCustomer(long phoneNum) ;
	Customers getCustomerId(String custName,long phoneNum);
	String getCustomerName(int custId) ;
}

