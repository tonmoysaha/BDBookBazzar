package com.bookbazzar.controller.frontend.book;

import com.bookbazzar.controller.BaseServlet;
import com.bookbazzar.service.BookService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/view_category")//header frontend
public class ViewBookByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewBookByCategoryServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookService(request, response);
		bookService.listBooksByCategory();
	}

}
