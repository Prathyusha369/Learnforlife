package com.springmvchibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvchibernate.entity.Customer;
import com.springmvchibernate.entity.Registration;
import com.springmvchibernate.exception.CUstomerNotFoundException;
import com.springmvchibernate.exception.CustomerErrorResponse;
import com.springmvchibernate.service.CustomerService;
import com.springmvchibernate.service.RegistrationService;

@Controller("/")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping("/")
	public String home(Model m) {

		m.addAttribute("register", new Registration());

		return "register";

	}

	@RequestMapping("/registration")
	public String registration(@ModelAttribute("register") Registration registration) {

		String check = registrationService.register(registration);
		/*if(check.equals("student")) {
			m.addAttribute("check", "student");	
		}
		else if(check.equals("tutor")){
			m.addAttribute("check", "tutor");	
				
		}*/
		
		
		return "redirect:/";

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
