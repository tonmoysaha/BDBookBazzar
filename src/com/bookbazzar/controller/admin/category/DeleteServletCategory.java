package com.bookbazzar.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.controller.BaseServlet;
import com.bookbazzar.service.CategoryService;

/**
 * Servlet implementation class DeleteServletCategory
 */
@WebServlet("/admin/delete_category")
public class DeleteServletCategory extends BaseServlet {
	private static final long serialVersionUID = 1L;
 
    public DeleteServletCategory() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService categoryService = new CategoryService(entityManager, request, response);
		categoryService.deleteCategory();
	}

}
