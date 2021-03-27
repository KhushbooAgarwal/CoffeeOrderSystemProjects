package com.pack.coffee.model.service;

import java.util.ArrayList;

import com.pack.coffee.model.bean.AddOn;

public interface AddOnService {
	
	ArrayList<AddOn> getAllAddOn();
	AddOn getAddOnByName(String addOnName) ;
	
	float getAddOnPriceByName(String addOnName) ;
	
	float getAddOnPriceById(int addOnId);
	AddOn getAddOnDetailsById(int addOnId);
}
