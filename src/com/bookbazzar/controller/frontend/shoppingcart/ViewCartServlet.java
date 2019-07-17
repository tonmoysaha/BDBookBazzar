package com.bookbazzar.controller.frontend.shoppingcart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.dao.BookDAO;
import com.bookbazzar.entity.Book;

/**
 * Servlet implementation class ViewCartServlet
 */
@WebServlet("/view_cart")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object cartObject = request.getSession().getAttribute("cart");
		if (cartObject == null) {
			ShoppingCart shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
			
			/*
			BookDAO bookDAO =new BookDAO();
			Book book1 = bookDAO.get(3);
			Book book2 = bookDAO.get(5);
			Book book3 = bookDAO.get(7);
		
			
			shoppingCart.addItem(book1);
			
			shoppingCart.addItem(book2);
			shoppingCart.addItem(book2);
			
			shoppingCart.addItem(book3);
			*/
		}
		
		/*Book book = new Book();
		book.setTitle("java in action");
		book.setPrice(20);
		BookDAO bookDAO =new BookDAO();
		Book book = bookDAO.get(3);
		
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("cart");
		shoppingCart.addItem(book);*/
		
		String cartPage = "frontend/shopping_cart.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(cartPage);
		requestDispatcher.forward(request, response);
	}

}
