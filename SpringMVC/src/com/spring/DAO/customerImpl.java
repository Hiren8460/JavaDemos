package com.spring.DAO;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.entity.customer;

@Repository
public class customerImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<customer> getCustomers() {

		Session s = sessionFactory.getCurrentSession();
		
		Query <customer> thequery =s.createQuery("from customer order by last_name",customer.class);
		
		List<customer> thecustomer =thequery.getResultList();
		
		return thecustomer;
	}


	@Override
	@Transactional
	public void saveCustomer(customer cust) {
		// TODO Auto-generated method stub

		Session s = sessionFactory.getCurrentSession();
		
		
		s.saveOrUpdate(cust);
		
		
	}


	@Override
	@Transactional
	public customer getCustomers(int theId) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.getCurrentSession();
		
	customer cust = s.get(customer.class, theId);	
		
		return cust;
	}


	@Override
	@Transactional
	public customer deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.getCurrentSession();
		
		customer cust = s.get(customer.class, id);		
		
		s.delete(cust);
		
		return cust;
	}

}
