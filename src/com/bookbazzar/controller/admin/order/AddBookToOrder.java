package com.bookbazzar.controller.admin.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookbazzar.dao.BookDAO;
import com.bookbazzar.entity.Book;
import com.bookbazzar.entity.BookOrder;
import com.bookbazzar.entity.OrderDetail;

/**
 * Servlet implementation class AddBookToOrder
 */
@WebServlet("/admin/add_book_to_order")
public class AddBookToOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookToOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		BookDAO bookDAO = new BookDAO();
		Book  book = bookDAO.get(bookId);
		float subtotal = quantity*book.getPrice();
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setBook(book);
		orderDetail.setQuantity(quantity);
		orderDetail.setSubtotal(subtotal);
		
		HttpSession session = request.getSession();
		BookOrder order = (BookOrder) session.getAttribute("order");
		
		float newTotal = order.getTotal()+subtotal;
		order.setTotal(newTotal);
		
		order.getOrderDetails().add(orderDetail);
		
		request.setAttribute("book", book);
		session.setAttribute("AddbookToOrderIsPanding", book);
		String result= "add_book_result.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(result);
		requestDispatcher.forward(request, response);
		
		
	}

}
