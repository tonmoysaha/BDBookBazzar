package com.bookbazzar.controller.frontend;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class CustomerLoginFilter implements Filter {

	private static final String[] loginRequiredURLs = { "/view_profile", "/update_profile", "/edit_profile" };

	public CustomerLoginFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);

		String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if (!path.startsWith("/admin/")) {
			chain.doFilter(request, response);
			return;
		}

		boolean logedIn = session != null && session.getAttribute("loggedcustomer") != null;
		String requestURL = httpRequest.getRequestURL().toString();

		if (!logedIn && isLoginRequired(requestURL)) {

			String loginPage = "frontend/login.jsp";
			RequestDispatcher requestDispatcher = httpRequest.getRequestDispatcher(loginPage);
			requestDispatcher.forward(request, response);

		} else {
			chain.doFilter(request, response);
		}

	}

	private boolean isLoginRequired(String requestURL) {
		for (String loginRequiredURL : loginRequiredURLs) {
			if (requestURL.contains(loginRequiredURL)) {
				return true;
			}

		}
		return false;
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
