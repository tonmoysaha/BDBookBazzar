package com.bookbazzar.controller.admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.dao.BookDAO;
import com.bookbazzar.entity.Book;


@WebServlet("/admin/add_book_form")
public class ShoeAddBookFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShoeAddBookFormServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDAO = new BookDAO();
		List<Book> listBook = bookDAO.listAll();
		request.setAttribute("listBook", listBook);
		String addBookForm = "add_book_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(addBookForm);
		requestDispatcher.forward(request, response);
	}

}
