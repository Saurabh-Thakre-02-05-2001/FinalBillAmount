package com.nt.controller;
import com.nt.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.nt.service.*;
@Controller("customerController")
public class CustomerOperationController {
	
	@Autowired
	private ICustomerManagementService customerService;
	public String process_customer_details(Customer customer) throws Exception {
		String result=customerService.calculateFinalAmount(customer);
		return result;
	}
}

