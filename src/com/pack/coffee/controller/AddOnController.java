package com.pack.coffee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pack.coffee.model.bean.AddOn;
import com.pack.coffee.model.bean.Coffee;
import com.pack.coffee.model.bean.Customers;
import com.pack.coffee.model.bean.Vouchers;
import com.pack.coffee.model.service.AddOnService;
import com.pack.coffee.model.service.CoffeeService;
import com.pack.coffee.model.service.CustomerService;
import com.pack.coffee.model.service.OrderService;
import com.pack.coffee.model.service.OrderTransactionService;

@Controller
public class AddOnController {
	
	@Autowired
	private CustomerService customerServ;

	@Autowired
	private CoffeeService coffeeService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderTransactionService orderTransactionService;

	@Autowired
	private AddOnService addOnServ;

	@ModelAttribute("addOnName")
	public List<String> getAllAddOn() {
		ArrayList<AddOn> clist = addOnServ.getAllAddOn();
		List addOn=clist.stream().map(AddOn::getAddOnName).distinct().collect(Collectors.toList());
		return addOn;
	}
	
	@RequestMapping(path = "/addAddOn")
	public ModelAndView selectCoffee(@ModelAttribute("coffee") Coffee coffee,
			@ModelAttribute("customer") Customers customer, @ModelAttribute("voucher") Vouchers voucher,
			@ModelAttribute("addOn") AddOn addOn) {
		ModelAndView mv = new ModelAndView();
		List<AddOn> addOnList1 = addOnServ.getAllAddOn();
		 mv.setViewName("addOnPage");
		mv.addObject("addOnList", addOnList1);
		
		// orderTransactionService.createOrderTran(orderId, coffee.getCoffeeName(),
		// coffee.getCoffeeSize(), addOn.getAddOnName());
		return mv;
	}


}
