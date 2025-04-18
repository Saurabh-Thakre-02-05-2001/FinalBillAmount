package com.nt.dao;

import com.nt.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository("customerDAO")
public class CustomerDAOImpl implements ICustomerDAO {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOImpl.class);

    private static final String SQL_INSERT =
        "INSERT INTO CUSTOMER_DETAILS(Name, Address, BillAmount, Discount, FinalAmount) VALUES (?, ?, ?, ?, ?)";

    @Autowired
    private DataSource dataSource;

    @Override
    public int insert_details(Customer customer) throws Exception {
        logger.info("Inserting data for customer: {}", customer.getCustomer_name());
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {

            ps.setString(1, customer.getCustomer_name());
            ps.setString(2, customer.getCustomer_address());
            ps.setDouble(3, customer.getBill_amount());
            ps.setDouble(4, customer.getDiscount());
            ps.setDouble(5, customer.getFinal_amount());

            int result = ps.executeUpdate();
            logger.info("Customer inserted successfully, result = {}", result);
            return result;

        } catch (Exception e) {
            logger.error("Error while inserting customer", e);
            throw e;
        }
    }
}
