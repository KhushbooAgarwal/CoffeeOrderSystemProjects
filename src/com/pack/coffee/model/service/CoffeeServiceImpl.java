package com.pack.coffee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.coffee.model.bean.Coffee;
import com.pack.coffee.model.dao.CoffeeDao;


@Service("CoffeeService")
public class CoffeeServiceImpl implements CoffeeService {
	@Autowired
	private CoffeeDao coffeeDao;
	
	public void setCoffeeDao(CoffeeDao coffeeDao) {
		this.coffeeDao = coffeeDao;
	}

	ArrayList<Coffee> coffeeList = new ArrayList<>();
	@Override
	public ArrayList<Coffee> getAllCoffeeDetails()  {
		// TODO Auto-generated method stub
		return coffeeDao.getAllCoffeeDetails();
	}
	
	@Override
	public ArrayList<String> getAllCoffeeNameDetails()  {
		
		return coffeeDao.getAllCoffeeNameDetails();
	}

	@Override
	public Coffee getCoffeeByNameAndSize(String coffeeName, String coffeeSize)  {
		return coffeeDao.getCoffeeByNameAndSize(coffeeName, coffeeSize);
		 
	}

	@Override
	public float getPriceByCoffeeId(int coffeeId)  {
		return coffeeDao.getPriceByCoffeeId(coffeeId);
	}

	@Override
	public ArrayList<String> getAllCoffeeSize()  {
		return coffeeDao.getAllCoffeeSize();
	}

	@Override
	public Coffee getCoffeeDetailsById(int coffeeId)  {
		return coffeeDao.getCoffeeDetailsById(coffeeId);
	}

	

}
