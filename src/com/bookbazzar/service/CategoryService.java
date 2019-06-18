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
	private EntityManager entityManager;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private CategoryDAO categoryDAO;
	
	public CategoryService(EntityManager entityManager,HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.entityManager =entityManager;
		categoryDAO = new CategoryDAO(entityManager);
	}
	public void listCategory() throws ServletException, IOException {
		listCategory(null);
		
	}
	public void listCategory(String massage) throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		
		if (massage != null) {
			request.setAttribute("massage", massage);
		}
		
		request.setAttribute("listCategory", listCategory);
		
		String categoryListPage= "category_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(categoryListPage);
		requestDispatcher.forward(request, response);
		
		
	}
	public void createCategory() throws ServletException, IOException {
		String categoryName = request.getParameter("name");
		String massage;
		Category existCategory = categoryDAO.findByName(categoryName);
		if(existCategory != null)
		{
		massage="Could not create Category"+" "+"This Category with this name"+categoryName+" is already exist";
			request.setAttribute("message", massage);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			Category category = new Category(categoryName);
			categoryDAO.create(category);
			massage ="Category Create Successfully";
			listCategory(massage);
			
		}
		
	}
	public void editCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category= categoryDAO.get(categoryId);
		if (category == null) {
			String massage="Could not edit the Category"+" "+"This Category with this ID: "+categoryId+" is not found";
			request.setAttribute("message", massage);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
		}
			request.setAttribute("category", category);
			String editForm = "category_form.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(editForm);
			requestDispatcher.forward(request, response);
			
		
	}
	public void updateCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("name");
		String massage;
		
		Category categoryById= categoryDAO.get(categoryId);
		Category categoryByName= categoryDAO.findByName(categoryName);
		if (categoryByName != null && categoryByName.getCategoryId() != categoryById.getCategoryId()) {
			massage ="could not updated "+categoryName+"is alredy Exist";
			request.setAttribute("massage", massage);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
			
		}else {
			categoryById.setName(categoryName);
			categoryDAO.update(categoryById);
			massage ="Category Update Successfully";
			listCategory(massage);
		}
		
	}
	public void deleteCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category =categoryDAO.get(categoryId);
		if (category == null) {
			String massage="Could not Delete the Category"+" "+"This Category with this ID: "+categoryId+" is not found";
			request.setAttribute("message", massage);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
		}else {
			categoryDAO.delete(categoryId);
			String massage= "This Category with this ID: "+categoryId+" is delected successfully";
			listCategory(massage);
		}
		
		
	}


	

}