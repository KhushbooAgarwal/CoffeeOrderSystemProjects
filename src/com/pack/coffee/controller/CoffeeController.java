package com.pack.coffee.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pack.coffee.model.bean.AddOn;
import com.pack.coffee.model.bean.Coffee;
import com.pack.coffee.model.bean.Customers;
import com.pack.coffee.model.bean.Orders;
import com.pack.coffee.model.bean.Vouchers;
import com.pack.coffee.model.service.AddOnService;
import com.pack.coffee.model.service.CoffeeService;
import com.pack.coffee.model.service.CustomerService;
import com.pack.coffee.model.service.OrderService;
import com.pack.coffee.model.service.OrderTransactionService;

@Controller
public class CoffeeController {
	
	
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

	
	
	@ModelAttribute("coffeeName")
	public List<String> getAllCoffeeName() {
		List<String> clist = coffeeService.getAllCoffeeNameDetails();
		return clist;
	}

	@ModelAttribute("coffeeSize")
	public List<String> getAllCoffeeSize() {
		ArrayList<String> clist = coffeeService.getAllCoffeeSize();
		return clist;
	}
	
	
	@RequestMapping(path = "/coffeeSelect")
	public ModelAndView selectCoffee(@ModelAttribute("coffee") Coffee coffee,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Customers cust = null;
        ArrayList<Coffee> clist = coffeeService.getAllCoffeeDetails();
		mv.setViewName("coffeePage");
		mv.addObject("coffeeList", clist);
		 SimpleDateFormat formatter = new
		 SimpleDateFormat("dd/MM/yyyy"); Date date = new Date();
		 Long phoneNumber=(Long)session.getAttribute("phoneNumber");
         System.out.println(phoneNumber);	 
		  
		 
		/*
		 * int orderId = orderService.CreateOrder(cust.getCustomerID(),
		 * formatter.format(date), 0); if(orderId!=0) {
		 * System.out.println("Order created"); }
		 */
		//List<AddOn> addOnList1 = addOnServ.getAllAddOn();
		// mv.setViewName("addOnPage");
		//mv.addObject("addOnList", addOnList1);
		//}
		// orderTransactionService.createOrderTran(orderId, coffee.getCoffeeName(),
		// coffee.getCoffeeSize(), addOn.getAddOnName());
		return mv;
	}
	
	
}
