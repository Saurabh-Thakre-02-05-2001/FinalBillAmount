package com.nt.test;
import com.nt.controller.CustomerOperationController;

import com.nt.model.Customer;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class RealtimeDITest {
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:");
		String name=sc.next();
		System.out.println("Enter your address:");
		String address=sc.next();
		System.out.println("Enter Bill Amount:");
		Double billAmount=sc.nextDouble();
		System.out.println("Enter Discount Amount:");
		Double discount=sc.nextDouble();
		
		//Create customer class object
		Customer customer=new Customer();
		customer.setCustomer_name(name);
		customer.setCustomer_address(address);
		customer.setBill_amount(billAmount);
		customer.setDiscount(discount);
		
		try {
			ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/config/applicationContext.xml");
			CustomerOperationController controller=ctx.getBean("Customer_controller",CustomerOperationController.class);
			String result=controller.process_customer_details(customer);
			System.out.println(result);
		}
//		catch(SQLException se) {
//			if(se.getErrorCode()==12899) {
//				System.out.println("Problem with column size.....");
//			}
//			else {
//				System.out.println("One or Other DB problem......");
//			}
//		}
//		catch(Exception e){
//			System.out.println("Non DB problem......");
//		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
}
