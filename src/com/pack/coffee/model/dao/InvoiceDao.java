package com.pack.coffee.model.dao;


import com.pack.coffee.model.bean.Invoices;


public interface InvoiceDao {
	
	int CreateInvoice(int invoiceNum,int orderId,float netValue,float gst,float serviceTax,float total,float price,float voucherAmt);
	Invoices getInvoiceByOrderId(int orderId);
	public int getMaxInvoiceId();
	
	
}
