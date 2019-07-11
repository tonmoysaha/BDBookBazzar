package com.bookbazzar.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.bookbazzar.dao.CategoryDAO;
import com.bookbazzar.entity.Category;

/**
 * Servlet Filter implementation class CommonFilter
 */
@WebFilter("/*")
public class CommonFilter implements Filter {
	private final CategoryDAO categoryDAO; 

    public CommonFilter() {
    categoryDAO = new CategoryDAO();
   
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest =(HttpServletRequest) request;
		String path = httprequest.getRequestURI().substring(httprequest.getContextPath().length());
		if (!path.startsWith("/admin/")) {
			List<Category> listCategory = categoryDAO.listAll();
			request.setAttribute("listCategory", listCategory);
			System.out.println("CommonFilter->doFilter");
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
