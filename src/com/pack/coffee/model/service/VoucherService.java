package com.pack.coffee.model.service;

import java.util.ArrayList;

import com.pack.coffee.model.bean.Vouchers;

public interface VoucherService {
	ArrayList<Vouchers> getAllVochers();
	Vouchers getVoucherByVoucherName(String voucherName) ;
}

