package com.bookbazzar.controller.admin.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.controller.BaseServlet;
import com.bookbazzar.service.BookService;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/admin/update_book")
@MultipartConfig(
		fileSizeThreshold = 1024 * 10, // 10kb
		maxFileSize = 1024 * 300, //300kb
		maxRequestSize = 1024 * 1024 // 1mb
		)
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateBookServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               BookService bookService = new BookService(request, response);
               bookService.updateBook();
	}

}
