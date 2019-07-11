package com.bookbazzar.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookbazzar.entity.Customer;

public class CustomerDAO extends jpaDAO<Customer> implements GenericDAO<Customer> {
	
	

	@Override
	public Customer create(Customer customer) {
		customer.setRegisterDate(new Date());
		return super.create(customer);
	}
	
	

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return super.update(customer);
	}



	@Override
	public Customer get(Object id) {
		// TODO Auto-generated method stub
		return super.find(Customer.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Customer.class, id);
		
	}

	@Override
	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNamedQery("Customer.findAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.countWithNamedQuery("Customer.countAll");
	}
	public Customer findByEmail(String email) {
		List<Customer> findWithNamedEmail = super.findWithNamedQery("Customer.findByEmail", "email", email);
		
		if (!findWithNamedEmail.isEmpty()) {
			return findWithNamedEmail.get(0);
		}
		return null;
	}
	public Customer checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		parameters.put("password", password);
		List<Customer> result = super.findWithNamedQery("Customer.checkLogin", parameters);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
		
	}

}
