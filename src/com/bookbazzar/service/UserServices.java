package com.bookbazzar.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.dao.userDAO;
import com.bookbazzar.entity.Users;

public class UserServices {
	private EntityManager entityManager;
	private userDAO userDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		userDAO = new userDAO(entityManager);
	}

	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	public void listUser(String message) throws ServletException, IOException {

		List<Users> listUsers = userDAO.listAll();
		request.setAttribute("listUsers", listUsers);

		if (message != null) {
			request.setAttribute("message", message);
		}

		String userlist = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(userlist);
		requestDispatcher.forward(request, response);

	}

	// adding new user in user list
	public void createUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");

		Users existUser = userDAO.findByEmail(email);
		if (existUser != null) {
			String massage = "this user with email address: " + email + " is alreadey exist";
			request.setAttribute("message", massage);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			Users newUser = new Users(email, fullname, password);
			userDAO.create(newUser);
			listUser("New User Create Successfully");
		}

	}

	// populate the user form for update the existing user
	public void editUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.get(userId);
		if (user == null) {
			String massage = "Could not find user with: " + userId;
			request.setAttribute("message", massage);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			user.getEmail();
			user.getFullname();
			user.getPassword();
			request.setAttribute("user", user);
			String upadateuser = "user_form.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(upadateuser);
			requestDispatcher.forward(request, response);
		}

	}

	// update user details
	public void updateUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		Users userById = userDAO.get(userId);

		Users findByEmail = userDAO.findByEmail(email);
		if (findByEmail != null && userById.getUserId() != findByEmail.getUserId()) {
			String massage = "User can not update Successfully ,This email is already exist";
			request.setAttribute("message", massage);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			Users user = new Users(userId, email, fullName, password);
			userDAO.update(user);
			String message = "User has been Updated successfully";
			listUser(message);
		}

	}

	public void deleteUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		String message;

		Users user = userDAO.get(userId);

		if (user == null) {
			message = "User has been delected already with this userId: " + userId;
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
		}
		if (user.getUserId() == 32) {
			message = "The default admin user account cannot be deleted with this id" + user.getUserId();
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
		} else {
			userDAO.delete(userId);
			message = "User has been Delected successfully";
			request.setAttribute("message", message);
			listUser(message);
		}

	}

	public void login() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		boolean loginResult = userDAO.checkLogin(email, password);
		if (loginResult) {
			request.getSession().setAttribute("useremail", email);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
			requestDispatcher.forward(request, response);
		} else {
			String message = "The  admin user account cannot be found";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
