package com.bookbazzar.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookbazzar.controller.frontend.shoppingcart.ShoppingCart;
import com.bookbazzar.dao.OrderDAO;
import com.bookbazzar.entity.Book;
import com.bookbazzar.entity.BookOrder;
import com.bookbazzar.entity.Customer;
import com.bookbazzar.entity.OrderDetail;

public class OrderServices {
	private OrderDAO orderDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public OrderServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.orderDAO = new OrderDAO();
	}
	public void listAllOrder() throws ServletException, IOException {
	 listAllOrder(null);
	}

	public void listAllOrder(String massage) throws ServletException, IOException {
		List<BookOrder> listOrder = orderDAO.listAll();
		if (massage != null) {
			request.setAttribute("massage", massage);
		}
		request.setAttribute("listOrder", listOrder);
		String orderPage = "list_order.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(orderPage);
		requestDispatcher.forward(request, response);

	}

	public void viewOrderDetailsForAdmin() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		BookOrder order = orderDAO.get(orderId);
		if (order == null) {
			String massage = "Order is not found.Because this order is deleted by another Admin";
			listAllOrder(massage);
			return;
		}
		request.setAttribute("order", order);
		String orderDetailPage = "order_detail.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(orderDetailPage);
		requestDispatcher.forward(request, response);
		
	}
	public void deleteOrder() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		BookOrder bookOrder = orderDAO.get(orderId);
		if (bookOrder == null) {
			String massage = "Order is not found.Because this order is deleted by another Admin";
			listAllOrder(massage);
			return;
		}
		orderDAO.delete(orderId);
		String massage = "Orderhas been deleted successfully";
		listAllOrder(massage);
		
	}
	public void showCheckOutPage() throws ServletException, IOException {
		String checkOutPage = "frontend/checkout.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(checkOutPage);
		requestDispatcher.forward(request, response);
	}
	public void placeOrder() throws ServletException, IOException {
		String recipientfullname =  request.getParameter("recipientfullname");
		String recipientphone = request.getParameter("recipientphone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		String paymentmethod = request.getParameter("paymentmethod");
		
		BookOrder bookOrder = new BookOrder();
		bookOrder.setRecipientName(recipientfullname);
		bookOrder.setRecipientPhone(recipientphone);
		String shippingAddress = address+", "+city+", "+zipcode+", "+country;
		bookOrder.setShippingAddress(shippingAddress );
		bookOrder.setPaymentMethod(paymentmethod);
		
		HttpSession session =  request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedcustomer");
		bookOrder.setCustomer(customer);
		
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
		Map<Book, Integer> items = shoppingCart.getItems();
		
		Iterator<Book> iterator = items.keySet().iterator();
		
		Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();
		
		while (iterator.hasNext()) {
			Book book = (Book) iterator.next();
			Integer quantity = items.get(book);
			float subtotal = quantity * book.getPrice();
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setBook(book);
			orderDetail.setBookOrder(bookOrder);
			orderDetail.setQuantity(quantity);
			orderDetail.setSubtotal(subtotal);
			
			orderDetails.add(orderDetail);
		}
		bookOrder.setOrderDetails(orderDetails);
		bookOrder.setTotal(shoppingCart.getTotallAmount());
		
		orderDAO.create(bookOrder);
		shoppingCart.clear();
		String message = "Thank you! Your order has benn recived. "+ "We will deleivery your books in few days";
		request.setAttribute("message", message);
		String messagePage = "frontend/massage.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(messagePage);
		requestDispatcher.forward(request, response);
		
	
		
	}
	public void listOrderByCustomer() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedcustomer");
		List<BookOrder> listOrders = orderDAO.listByCustomer(customer.getCustomerId());
		
		request.setAttribute("listOrders", listOrders);
		String historyPage = "frontend/order_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(historyPage);
		requestDispatcher.forward(request, response);
		
	}
	
	public void showOrderDetailForCustomer() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedcustomer");
		
		BookOrder order = orderDAO.get(orderId,customer.getCustomerId());
		request.setAttribute("order", order);
		
		String orderDetailPage = "frontend/order_detail.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(orderDetailPage);
		requestDispatcher.forward(request, response);
		
	}
	
	public void showEditOrderForm() throws ServletException, IOException {
		
		int orderId = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		Object isPanding = session.getAttribute("AddbookToOrderIsPanding");
		if (isPanding == null) {
			BookOrder order = orderDAO.get(orderId);
			session.setAttribute("order", order);
		}else {
			session.removeAttribute("AddbookToOrderIsPanding");
		}
		
		String editOrderPage = "order_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editOrderPage);
		requestDispatcher.forward(request, response);
	}
	public void updateOrder() throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookOrder order = (BookOrder) session.getAttribute("order");
		
		String recipientfullname =request.getParameter("recipientfullname");
		String recipientPhone =request.getParameter("recipientPhone");
		String shippingAddress =request.getParameter("shippingAddress");
		String paymentMethod =request.getParameter("paymentMethod");
		String orderStatus =request.getParameter("orderStatus");
		
		order.setRecipientName(recipientfullname);
		order.setRecipientPhone(recipientPhone);
		order.setShippingAddress(shippingAddress);
		order.setPaymentMethod(paymentMethod);
		order.setStatus(orderStatus);
		
		String[] arrayBookId = request.getParameterValues("bookId");
		String[] arrayPrice = request.getParameterValues("price");
		String[] arrayQuantity = new String[arrayBookId.length];
		
		for (int i = 1; i <= arrayQuantity.length; i++) {
			arrayQuantity[i-1]= request.getParameter("quantity" + i);
		}
		
		Set<OrderDetail> orderDetails = order.getOrderDetails();
		orderDetails.clear();
		
		float totalAmount = 0.0f;
		for (int i = 0; i < arrayBookId.length; i++) {
			int bookId = Integer.parseInt(arrayBookId[i]);
			int quantity = Integer.parseInt(arrayQuantity[i]);
			float price = Float.parseFloat(arrayPrice[i]);
			
			float subTotal= quantity * price;
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setBook(new Book(bookId));
			orderDetail.setQuantity(quantity);
			orderDetail.setSubtotal(subTotal);
			orderDetail.setBookOrder(order);
			
			orderDetails.add(orderDetail);
			totalAmount+= subTotal;
			
		}
		order.setTotal(totalAmount);
		orderDAO.update(order);
		String massage = "The Order has been updated successfully";
		listAllOrder(massage);
		
		
	}

}
