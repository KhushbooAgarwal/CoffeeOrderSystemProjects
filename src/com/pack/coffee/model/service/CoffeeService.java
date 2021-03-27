package com.pack.coffee.model.service;

import java.util.ArrayList;

import com.pack.coffee.model.bean.Coffee;


public interface CoffeeService {
		
	ArrayList<Coffee> getAllCoffeeDetails();
	ArrayList<String> getAllCoffeeNameDetails();
	ArrayList<String> getAllCoffeeSize();
	
	Coffee getCoffeeByNameAndSize(String coffeeName, String coffeeSize) ;
	public float getPriceByCoffeeId(int coffeeId) ;
	Coffee getCoffeeDetailsById(int coffeeId);
}
