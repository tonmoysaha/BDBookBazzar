package com.bookbazzar.controller.frontend.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.service.OrderServices;

/**
 * Servlet implementation class ShowOrderDetailServlet
 */
@WebServlet("/show_order_detail")
public class ShowOrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowOrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     OrderServices orderServices = new OrderServices(request, response);
	     orderServices.showOrderDetailForCustomer();
	}

}
