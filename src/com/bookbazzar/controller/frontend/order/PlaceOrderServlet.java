package com.bookbazzar.controller.frontend.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.service.OrderServices;

@WebServlet("/palce_order")
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PlaceOrderServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderServices orderServices = new OrderServices(request, response);
		orderServices.placeOrder();
	}

}
