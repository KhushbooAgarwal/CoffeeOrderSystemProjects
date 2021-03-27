package com.pack.coffee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.coffee.model.bean.Vouchers;
import com.pack.coffee.model.dao.VoucherDao;

@Service("VoucherService")
public class VoucherServiceImpl implements VoucherService {
	@Autowired
	private VoucherDao vouchDao;
    
	public void setVouchDao(VoucherDao vouchDao) {
		this.vouchDao = vouchDao;
	}

	@Override
	public ArrayList<Vouchers> getAllVochers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vouchers getVoucherByVoucherName(String voucherName)  {
		
		return vouchDao.getVoucherByVoucherName(voucherName);
	}

}
