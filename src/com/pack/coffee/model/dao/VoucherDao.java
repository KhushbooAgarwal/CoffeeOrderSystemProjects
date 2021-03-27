package com.pack.coffee.model.dao;

import java.util.ArrayList;

import com.pack.coffee.model.bean.Vouchers;

public interface VoucherDao {

	ArrayList<Vouchers> getAllVouchers();
	Vouchers getVoucherByVoucherName(String voucherName);
	
}
