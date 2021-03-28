package com.pack.coffee.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pack.coffee.model.bean.AddOn;
import com.pack.coffee.model.bean.Coffee;
import com.pack.coffee.model.bean.Customers;
import com.pack.coffee.model.bean.OrderTransaction;
import com.pack.coffee.model.bean.Orders;
import com.pack.coffee.model.bean.Vouchers;
import com.pack.coffee.model.service.AddOnService;
import com.pack.coffee.model.service.CoffeeService;
import com.pack.coffee.model.service.CustomerService;
import com.pack.coffee.model.service.OrderService;
import com.pack.coffee.model.service.OrderTransactionService;

@Controller
public class CoffeeController {
	
	static int orderId;
	
	public static int getOrderId() {
		return orderId;
	}

	

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
	
	@ModelAttribute("addOnName")
	public List<String> getAllAddOn() {
		ArrayList<AddOn> clist = addOnServ.getAllAddOn();
		List addOn=clist.stream().map(AddOn::getAddOnName).distinct().collect(Collectors.toList());
		return addOn;
	}
	
	
	@RequestMapping(value = "/coffeeSelect")
	public ModelAndView selectCoffee(@ModelAttribute("coffee") Coffee coffee,HttpSession session,
	        final BindingResult coffeeBindingResult,
	        final Model model, 
	        final RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView();
		Customers cust = null;
		String cName="",cSize ="";
		 ArrayList<Coffee> clist = coffeeService.getAllCoffeeDetails();
		mv.setViewName("coffeePage");
		mv.addObject("coffeeList", clist);
		mv.addObject("cName",coffee.getCoffeeName()); 
		System.out.println("Selected coffee Name"+coffee.getCoffeeName());
		mv.addObject("cSize", coffee.getCoffeeSize());
		 SimpleDateFormat formatter = new
		 SimpleDateFormat("dd/MM/yyyy"); 
		 Date date = new Date();
		 Long phoneNumber=(Long)session.getAttribute("phoneNumber");
         System.out.println(phoneNumber);	
         int customerId = customerServ.checkCustomer(phoneNumber);
		  orderId = orderService.CreateOrder(customerId,
		  formatter.format(date), 0);
		  
		  redirectAttributes.addFlashAttribute("coffee",coffee);
		  if(orderId!=0) {
		  System.out.println("Order created");
			 }
		return mv;
		 
		
	}
	
	
	//@RequestMapping(path = "/addAddOn" )
	//@RequestMapping(path = "/addAddOn")
	@RequestMapping(value="/addAddOn", method = RequestMethod.POST)
	public ModelAndView addAddOn(HttpServletRequest request,@ModelAttribute("coffee") Coffee coffee,@ModelAttribute("addOn") AddOn addOn,
			HttpSession session,
	        final BindingResult coffeeBindingResult,
	        final Model model,ModelMap modelmap)
	{
		ModelAndView mv = new ModelAndView();
		String aOName="";
	 List<AddOn> addOnList1 = addOnServ.getAllAddOn();
	  mv.setViewName("addOnPage");
	  mv.addObject("addOnList", addOnList1);
	  mv.addObject("aOName", addOn.getAddOnName());
	  System.out.println("orderId"+orderId);
	   System.out.println("coffeeName"+coffee.getCoffeeName());
	  System.out.println("coffeeSize"+coffee.getCoffeeSize());
	  System.out.println("addOnName"+addOn.getAddOnName());
	  //orderTransactionService.createOrderTran(orderId, (String)session.getAttribute("coffeeName"),(String) session.getAttribute("coffeeSize"), addOn.getAddOnName());
	  
	  return mv;
}
	@RequestMapping(path = "/invoice")
	public ModelAndView invoice(@ModelAttribute("addOn") AddOn addOn,
			HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	@RequestMapping(path = "/addVoucher")
	public ModelAndView voucherAdd(@ModelAttribute("voucher") Vouchers vouchers,HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		 mv.setViewName("voucher");
		String voucherName = vouchers.getVoucherName();
		session.setAttribute("voucherName", vouchers.getVoucherName());
		return mv;
		
	}
	
	@RequestMapping(path = "/orderCreation")
	public ModelAndView orderCreation(HttpSession session)
	{
		ModelAndView mv = new ModelAndView();
		List<OrderTransaction> OrderTranDetail =  new ArrayList<OrderTransaction>();
		Coffee coffeeName=null;
		AddOn addOnName=null;
		String nameAddOn;
		Customers customer = customerServ.getCustomerByPhone((long)session.getAttribute("phoneNumber"));
		 mv.setViewName("orderCreationPage");
		  mv.addObject("customerName", customer.getCustomerName());
		  OrderTranDetail = orderTransactionService.getOrderTranByOrderID(orderId);
		  for(OrderTransaction list :OrderTranDetail) {
				coffeeName = coffeeService.getCoffeeDetailsById(list.getCoffeeId());
				mv.addObject("invoiceList", coffeeName);
				addOnName=addOnServ.getAddOnDetailsById(list.getAddOnID());
				if(addOnName==null)
					mv.addObject("invoiceList", "");
				else
					mv.addObject("invoiceList", addOnName);
				
					}
		return mv;
		
	}
	
}
