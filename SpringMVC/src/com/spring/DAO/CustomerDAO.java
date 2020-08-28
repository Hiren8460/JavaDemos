package com.spring.DAO;

import java.util.List;

import com.spring.entity.customer;

public interface CustomerDAO {

	public List<customer> getCustomers();

	public void saveCustomer(customer cust);

	public customer getCustomers(int theId);

	public customer deleteCustomer(int id);
	
}
