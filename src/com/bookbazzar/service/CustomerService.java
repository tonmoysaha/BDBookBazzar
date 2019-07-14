package com.bookbazzar.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.dao.CustomerDAO;
import com.bookbazzar.entity.Customer;

public class CustomerService {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CustomerDAO customerDAO;
	
	public CustomerService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		
		this.customerDAO = new CustomerDAO();
	}
	
	public void listCustomers() throws ServletException, IOException {
		listCustomers(null);
	}
	
	public void listCustomers(String message) throws ServletException, IOException {
		
		List<Customer> listCustomer = customerDAO.listAll();
		
		if(message != null)
		{
			request.setAttribute("message", message);
		}
		
		request.setAttribute("listCustomer", listCustomer);
		
		String listCustomerPage = "customer_list.jsp";
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listCustomerPage);
		requestDispatcher.forward(request, response);
	}
	
	public void createCustomer() throws ServletException, IOException {

		String email = request.getParameter("email");
		String message;
		Customer existCustomer = customerDAO.findByEmail(email);
		
		if (existCustomer != null) {
			message = "customer Could not create with this email:"+ email + "because its already exist";
			listCustomers(message);
		}else {
		
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromform(newCustomer);
			customerDAO.create(newCustomer);
			message = "New Customer has been created successfully";
			listCustomers(message);
		}
		
	}
	
	private void updateCustomerFieldsFromform(Customer customer) {
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		
		if (email != null && !email.equals("")) {
			customer.setEmail(email);
		}
		customer.setFullname(fullname);
		if (password != null && !password.equals("")) {
			customer.setPassword(password);
		}
		customer.setPhone(phone);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setZipcode(zipcode);
		customer.setCountry(country);
	}

	public void editCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));

		Customer customer = customerDAO.get(customerId);

		if (customer == null) {
			String massage = "Could not find Customer with this : " + customerId;
			request.setAttribute("message", massage);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			request.setAttribute("customer", customer);
			String editPage = "customer_form.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
			requestDispatcher.forward(request, response);
		}

	}

	public void updateCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("customerId"));
		
		String email = request.getParameter("email");
		String message;
		Customer existCustomer = customerDAO.findByEmail(email);
		if (existCustomer != null && existCustomer.getCustomerId() != customerId) {
			message = "could not update the customer Because This customer with this email: "
					+existCustomer.getEmail()+"is already Exist";
			
		}else {
			Customer customerById = customerDAO.get(customerId);
			updateCustomerFieldsFromform(customerById);
			customerDAO.update(customerById);
			message = "The customer has been updated successfully";
			
		}
		listCustomers(message);
		
	}

	public void deleteCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		String message;
		Customer customer = customerDAO.get(customerId);
		if (customer == null) {
			message = "The customer cou;d not found with this id"+customerId;
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		customerDAO.delete(customerId);
		 message = "This Customer has been deleted successfully with this email" + customer.getEmail();
		listCustomers(message);
		
	}

	public void registerCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		String message;
		Customer existCustomer = customerDAO.findByEmail(email);
		
		if (existCustomer != null) {
			message = " Could not Register with this email:"+ email + "because its already exist";
			
		}else {
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromform(newCustomer);
			customerDAO.create(newCustomer);
			message = "you have registered successfully, Thank you!<br/>"
					+"please Click Here To Log In the Page <br/>"+
					"<a href ='login.jsp' align='center'>Sign In</a>";
		}
		request.setAttribute("message", message);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("frontend/massage.jsp");
		requestDispatcher.forward(request, response);
	}

	public void showLogin() throws ServletException, IOException {
		
		String loginPage = "frontend/login.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(loginPage);
		requestDispatcher.forward(request, response);
		
	}

	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer = customerDAO.checkLogin(email, password);
		
		if (customer == null) {
			String message = "Login Failed, please check yous email and Password";
			request.setAttribute("message", message);
			showLogin();
		}else {
			request.getSession().setAttribute("loggedcustomer", customer);
			showCustomerProfile();
			
		}
		
		
	}

	public void showCustomerProfile() throws ServletException, IOException {
		String profilePage = "frontend/customer_profile.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(profilePage);
		requestDispatcher.forward(request, response);
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		String editPage = "frontend/edit_customer_profile.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
		
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedcustomer");
		updateCustomerFieldsFromform(customer);
		customerDAO.update(customer);
		showCustomerProfile();
	}

	
	

	

}
