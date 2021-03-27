package com.pack.coffee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.coffee.model.bean.AddOn;
import com.pack.coffee.model.dao.AddOnDao;

@Service("AddOnService")
public class AddOnServiceImpl implements AddOnService {
	@Autowired
	private AddOnDao addOnDao;
	

	public void setAddOnDao(AddOnDao addOnDao) {
		this.addOnDao = addOnDao;
	}


	@Override
	public ArrayList<AddOn> getAllAddOn() {
		return addOnDao.getAllAddOn();
	}

	
	@Override
	public AddOn getAddOnByName(String addOnName)  {
		return addOnDao.getAddOnByName(addOnName);
	}

	@Override
	public float getAddOnPriceByName(String name)  {
		return addOnDao.getAddOnPriceByName(name);
	}


	@Override
	public float getAddOnPriceById(int addOnId) {
		return addOnDao.getAddOnPriceById(addOnId);
	
	}


	@Override
	public AddOn getAddOnDetailsById(int addOnId)  {
		return addOnDao.getAddOnDetailsById(addOnId);
	}

}
