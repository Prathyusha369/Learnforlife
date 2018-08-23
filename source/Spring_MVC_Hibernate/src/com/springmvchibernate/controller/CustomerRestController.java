package com.springmvchibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvchibernate.entity.Customer;
import com.springmvchibernate.exception.CUstomerNotFoundException;
import com.springmvchibernate.exception.CustomerErrorResponse;
import com.springmvchibernate.service.CustomerService;

@RestController
@RequestMapping("/customerrest")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/view")
	public List<Customer> listAllCustomer(Model m) {

		return customerService.getList();

	}

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer customer) {

		customerService.saveCustomer(customer);

		return customer;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void putCustomer(@RequestBody Customer customer) {

		customerService.putCustomer(customer);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable("id") int customerid) {

		customerService.deleteCustomer(customerid);
		return "deleted";

	}

	@GetMapping("/list/{id}")

	public Customer getCustomer(@PathVariable int id) {

		Customer customer = customerService.getCustomer(id);
		if (customer == null) {

			throw new CUstomerNotFoundException("No Customer found");
		} else {

			return customer;
		}

	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e) {

		CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();
		customerErrorResponse.setMessage(e.getMessage());
		customerErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		customerErrorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity(customerErrorResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CUstomerNotFoundException e) {

		CustomerErrorResponse customerErrorResponse = new CustomerErrorResponse();
		customerErrorResponse.setMessage(e.getMessage());
		customerErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		customerErrorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity(customerErrorResponse, HttpStatus.NOT_FOUND);

	}

}
