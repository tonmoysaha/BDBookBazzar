package com.bookbazzar.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookbazzar.entity.Customer;

public class CustomerDAOTest {
	private static CustomerDAO customerDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDAO = new CustomerDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customerDAO.close();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer= new Customer();
		customer.setEmail("javalearnersite@gmail.com");
		customer.setFullname("java learner");
		customer.setCountry("U.S.A");
		customer.setCity("Newyork");
		customer.setAddress("Lincoln AVE");
		customer.setPassword("jjjj");
		customer.setZipcode("10009");
		customer.setPhone("+0442569854");
		Customer customer2 = customerDAO.create(customer);
		assertTrue(customer2.getCustomerId() > 0);
		
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDAO.get(1);
		String fullname = "tonmoy saha";
		customer.setFullname(fullname);
		Customer updateCustomer = customerDAO.update(customer);
		assertTrue(updateCustomer.getFullname().equals(fullname));
	}

	@Test
	public void testGetCustomer() {
		Integer customerId = 1;
		Customer customer = customerDAO.get(customerId);
		assertNotNull(customer);
	}

	@Test
	public void testDeleteCustomer() {
		Integer customerId = 1;
		customerDAO.delete(customerId);
		Customer customer = customerDAO.get(customerId);
		assertNull(customer);
	}

	@Test
	public void testListAllCustomer() {
		List<Customer> listCustomer = customerDAO.listAll();
		//assertTrue(listCustomer.size() > 0);
		assertFalse(listCustomer.isEmpty());
	}

	@Test
	public void testCountCustomer() {
		long totallCustomer = customerDAO.count();
		assertEquals(totallCustomer, 2);
	}
	@Test
	public void testFindByEmail() {
		String email = "tonmoysahaopi@gmail.com";
		Customer findByEmail = customerDAO.findByEmail(email);
		assertNotNull(findByEmail);
	}
	@Test
	public void testCheckLoginCustomer() {
		String email = "java@gmail.com";
		String password = "jjjj";
		Customer customer = customerDAO.checkLogin(email, password);
		assertNotNull(customer);
	}
	@Test
	public void testCheckLoginCustomerFail() {
		String email = "java@gmail.com";
		String password = "tttt";
		Customer customer = customerDAO.checkLogin(email, password);
		assertNull(customer);
	}

}
