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

import com.bookbazzar.dao.CategoryDAO;
import com.bookbazzar.entity.Category;

public class CategoryService {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CategoryDAO categoryDAO;
	
	public CategoryService(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		entityManagerFactory = Persistence.createEntityManagerFactory("BookBazzarWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		categoryDAO = new CategoryDAO(entityManager);
	}

	public void listCategory() throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		
		request.setAttribute("listCategory", listCategory);
		
		String categoryListPage= "category_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(categoryListPage);
		requestDispatcher.forward(request, response);
		
		
	}

}