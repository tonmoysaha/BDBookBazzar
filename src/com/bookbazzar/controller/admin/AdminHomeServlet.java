package com.bookbazzar.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.dao.BookDAO;
import com.bookbazzar.dao.CustomerDAO;
import com.bookbazzar.dao.OrderDAO;
import com.bookbazzar.dao.ReviewDAO;
import com.bookbazzar.dao.userDAO;
import com.bookbazzar.entity.Book;
import com.bookbazzar.entity.BookOrder;
import com.bookbazzar.entity.Review;

/**
 * Servlet implementation class AdminHomeServlet
 */
@WebServlet("/admin/")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminHomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDAO orderDAO = new OrderDAO();
		ReviewDAO reviewDAO = new ReviewDAO();
		BookDAO bookDAO = new BookDAO();
		userDAO userDAO = new userDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		List<BookOrder> listMostRecentsells = orderDAO.listMostRecentSells();
		List<Review> listMostrecentReviews = reviewDAO.listMostRecentReviews();
		
		long totallUser = userDAO.count();
		long totallBook = bookDAO.count();
		long totallCustomer = customerDAO.count();
		long totallReviews = reviewDAO.count();
		long totallOrder = orderDAO.count();
		
		request.setAttribute("listMostRecentsells", listMostRecentsells);
		request.setAttribute("listMostrecentReviews", listMostrecentReviews);
		
		request.setAttribute("totallUser", totallUser);
		request.setAttribute("totallBook", totallBook);
		request.setAttribute("totallCustomer", totallCustomer);
		request.setAttribute("totallReviews", totallReviews);
		request.setAttribute("totallOrder", totallOrder);
		
		
		String adminhome = "index.jsp";
		RequestDispatcher dispatchar = request.getRequestDispatcher(adminhome);
		dispatchar.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
