package com.pack.coffee.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pack.coffee.model.bean.AddOn;



public interface AddOnDao {	
	
	ArrayList<AddOn> getAllAddOn();
	AddOn getAddOnByName(String addOnName);
	public float getAddOnPriceByName(String name);
	public float getAddOnPriceById(int addOnId);
	AddOn getAddOnDetailsById(int addOnId);
}
