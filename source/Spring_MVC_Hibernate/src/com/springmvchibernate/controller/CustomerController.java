package com.springmvchibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvchibernate.dao.CustomerDao;
import com.springmvchibernate.entity.Customer;
import com.springmvchibernate.service.CustomerService;

@RestController
@RequestMapping("/customer" )
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping({ "/view", "/" })
	@ResponseBody
	public List<Customer> listAllCustomer(Model m) {

		
		return customerService.getList();
		/*m.addAttribute("customers", customerService.getList());
		*///return "listCustomers";
	}

	@RequestMapping("/add")
	public String addCustomer(Model m) {

		m.addAttribute("customer",new Customer());
		return "add";
	}

	
	
	@RequestMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		
		customerService.saveCustomer(customer);
		return "redirect:view/";
	}
}
