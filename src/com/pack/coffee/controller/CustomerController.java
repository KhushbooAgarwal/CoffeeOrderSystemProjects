package com.pack.coffee.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pack.coffee.model.bean.Customers;
import com.pack.coffee.model.service.CustomerService;
import com.pack.coffee.model.service.OrderService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private OrderService orderService;

	static int orderId;
	static String custName;

	public int getOrderId() {
		return orderId;
	}

	public String getCustName() {
		return custName;
	}

	@RequestMapping(path = "/")
	public ModelAndView mainPageController() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MainPage");
		return mv;

	}

	@RequestMapping(path = "/CheckCustomer")
	public ModelAndView checkCustomer() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customerPage");
		mv.addObject("customer", new Customers());
		return mv;

	}

	@RequestMapping(value = "/searchCustomer")
	public ModelAndView checkCustomer(HttpSession session,@ModelAttribute("customer") Customers customer) {
		ModelAndView mv = new ModelAndView();
		String greet = null;
		int customerId = 0;

		Customers cust = new Customers();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		cust = customerService.getCustomerByPhone(customer.getPhoneNumber());

		if (cust != null) {
			greet = "Welcome";
			customerId = cust.getCustomerID();
			custName = cust.getCustomerName();
			//orderId = orderService.CreateOrder(customerId, formatter.format(date), 0);

			mv.setViewName("welcomePage");
			mv.addObject("greet", greet);
			mv.addObject("customer", cust.getCustomerName());
			mv.addObject("phoneNumber", cust.getPhoneNumber());
			session.setAttribute("phoneNumber", cust.getPhoneNumber());
			System.out.println("old customer");
		} else {
			System.out.println("new Customer");
			mv.setViewName("customerNamePage");
			mv.addObject("phoneNumber", customer.getPhoneNumber());
		}
		return mv;
	}

	@RequestMapping(path = "/addCustomer")
	public ModelAndView insertCustName(HttpSession session,@ModelAttribute("customer") Customers customer) {
		ModelAndView mv = new ModelAndView();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		int customerId = customerService.addCustomer(customer.getCustomerName(), customer.getPhoneNumber());
		custName = customer.getCustomerName();
		String message = "";
		if (customerId != 0) {
			//orderId = orderService.CreateOrder(customerId, formatter.format(date), 0);
			mv.setViewName("welcomePage");
			mv.addObject("customer", customer.getCustomerName());
			mv.addObject("phoneNumber",customer.getPhoneNumber());
			mv.addObject("customer1", new Customers());
			session.setAttribute("phoneNumber", customer.getPhoneNumber());
		} else {
			message = "Something went Wrong,Please Try again later!";
			mv.setViewName("customerNamePage");
			mv.addObject("message", message);
		}
		return mv;

	}

}
