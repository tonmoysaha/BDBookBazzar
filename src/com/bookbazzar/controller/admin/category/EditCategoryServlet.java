package com.bookbazzar.controller.admin.category;

import com.bookbazzar.controller.BaseServlet;
import com.bookbazzar.service.CategoryService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCategoryServlet
 */
@WebServlet("/admin/edit_category")
public class EditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public EditCategoryServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService categoryService = new CategoryService(request, response);
		categoryService.editCategory();
	}

}
