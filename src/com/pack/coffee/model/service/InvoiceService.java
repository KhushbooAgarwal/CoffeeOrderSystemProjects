package com.pack.coffee.model.service;

import com.pack.coffee.model.bean.Invoices;


public interface InvoiceService {
	
	int createInvoice(int orderId,String  voucherName,String coffeeName,String coffeeSize ,String addOnName);
	Invoices getInvoiceByOrderId(int orderId) ;
	public void showInvoice(int orderId,int customerId) ;

}
