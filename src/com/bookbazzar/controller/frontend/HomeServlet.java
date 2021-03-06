package com.bookbazzar.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.controller.BaseServlet;
import com.bookbazzar.dao.BookDAO;
import com.bookbazzar.dao.CategoryDAO;
import com.bookbazzar.entity.Book;
import com.bookbazzar.entity.Category;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoryDAO categoryDAO = new CategoryDAO();
		
		BookDAO bookDAO = new BookDAO();
		List<Book> listNewBooks = bookDAO.listNewBooks();
		List<Book> listbestSellingBooks = bookDAO.bestSellingBooks();
		List<Book> listMostFavouredBooks = bookDAO.listMostFavouredBooks();

		
		request.setAttribute("listNewBooks", listNewBooks);
		request.setAttribute("listbestSellingBooks", listbestSellingBooks);
		request.setAttribute("listMostFavouredBooks", listMostFavouredBooks);
		
		String homepage = "frontend/index.jsp";
		RequestDispatcher dispatchar= request.getRequestDispatcher(homepage);
		dispatchar.forward(request, response);
	}



}
