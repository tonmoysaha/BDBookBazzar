package com.bookbazzar.controller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.controller.BaseServlet;
import com.bookbazzar.service.BookService;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/admin/edit_book")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        BookService bookService = new BookService(request, response);
	        bookService.editBook();
	}

}
