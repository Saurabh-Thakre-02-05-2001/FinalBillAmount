package com.nt.service;
import com.nt.dao.*;
import com.nt.model.Customer;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service("customerService")
public class CustomerManagementServiceImpl implements ICustomerManagementService{
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	public String calculateFinalAmount(Customer customer) throws Exception{
		//Calculating Final Bill Amount
		double discount_Amount=((customer.getBill_amount())*(customer.getDiscount()/100.0));
		double final_Amount=(customer.getBill_amount()-discount_Amount);
		
		// set finalAmount to the model object
	   customer.setFinal_amount(final_Amount);
	   
	   //use DAO
	   int count=customerDAO.insert_details(customer);
	   return count==0 ? "Customer Registeration failed..." :"Customer Registered Successfully having BillAmount: "+customer.getBill_amount()+" Discount: "+discount_Amount+" FinalBillAmout: "+final_Amount;
	}
}
