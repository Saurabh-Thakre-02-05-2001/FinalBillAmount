package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.CustomerOperationController;
import com.nt.model.Customer;


public class RealTimeDITest1 {

    public static void main(String[] args) {
        // Load Spring container from XML
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/config/applicationContext.xml");

        // Get Controller Bean
        CustomerOperationController controller = ctx.getBean("customerController", CustomerOperationController.class);

        // Create sample customer object
        Customer cust = new Customer();
        cust.setCustomer_name("John Doe");
        cust.setCustomer_address("Mumbai");
        cust.setBill_amount(5000.0);
        cust.setDiscount(15.0);

        try {
            String result = controller.process_customer_details(cust);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ctx.close();
    }
}

