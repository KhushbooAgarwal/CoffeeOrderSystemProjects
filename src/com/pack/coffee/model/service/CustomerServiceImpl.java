package com.pack.coffee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.coffee.model.bean.Customers;
import com.pack.coffee.model.dao.CustomerDao;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao custDao;
	
	@Override
	public int addCustomer(String custName, long phoneNum)  {
		
		Customers customer=null;
		int result = 0;
		
		customer = custDao.getCustomerByPhone(phoneNum);
		
		if(customer!=null) {
			result =customer.getCustomerID();
		}
		else {
			int custId= custDao.getMaxCustomer();
			custId = custId+1;
			custDao.addCustomer(custId,custName, phoneNum);
			result = custId;
		}
			return result;
	}

	@Override
	public Customers getCustomerByPhone(long phoneNum)  {
		return custDao.getCustomerByPhone(phoneNum);	
		
	}

	@Override
	public int checkCustomer(long phoneNum) {
		
		return custDao.checkCustomer(phoneNum);
	}

	@Override
	public Customers getCustomerId(String custName, long phoneNum)  {
				return custDao.getCustomerId(custName, phoneNum);
	}

	@Override
	public String getCustomerName(int custId) {
		return  custDao.getCustomerName(custId);
	}

}
