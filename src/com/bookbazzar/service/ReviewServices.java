package com.bookbazzar.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookbazzar.dao.BookDAO;
import com.bookbazzar.dao.ReviewDAO;
import com.bookbazzar.entity.Book;
import com.bookbazzar.entity.Customer;
import com.bookbazzar.entity.Review;


public class ReviewServices {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ReviewDAO reviewDAO;
	
	public ReviewServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		
		this.reviewDAO = new ReviewDAO();
	}
	
	public void listAllReviews() throws ServletException, IOException {
		listAllReviews(null);
	}

	public void listAllReviews(String massage) throws ServletException, IOException {
		
	List<Review> listReviews = reviewDAO.listAll();
	
	if (massage != null) {
		request.setAttribute("massage", massage);
	}
	
	request.setAttribute("listReviews", listReviews);
	
	String reviewPage = "review_list.jsp";
	RequestDispatcher requestDispatcher = request.getRequestDispatcher(reviewPage);
	requestDispatcher.forward(request, response);
		
	}

	public void editReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		
		Review review = reviewDAO.get(reviewId);
		
		if (review == null) {
			String message = "The Review could not Edit with this title '" + review.getBook()+ "' already Deleted";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
			return;
			
		}else {
			request.setAttribute("review", review);
			String editPage = "review_form.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
			requestDispatcher.forward(request, response);
		}
		
	}

	public void updateReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("reviewId"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		
		Review review = reviewDAO.get(reviewId);
		review.setHeadline(headline);
		review.setComment(comment);
		
		reviewDAO.update(review);
		
		String massage = "Review has been updated successfully";
		listAllReviews(massage);
		
	}

	public void deleteReview() throws ServletException, IOException {
		Integer reviewId = Integer.parseInt(request.getParameter("id"));
		
		Review review = reviewDAO.get(reviewId);
		if (review == null) {
			String message = "The Review could not Delete with this title '" + review.getBook()+ "' already Deleted";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
			return;
		}else {
			reviewDAO.delete(reviewId);
			String massage = "Review has been Deleted successfully";
			listAllReviews(massage);
		}
		
	}

	public void showReviewForm() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("book_id"));
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.get(bookId);
		request.getSession().setAttribute("book", book);
		String targetPage = "frontend/review_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(targetPage);
		requestDispatcher.forward(request, response);
		
	}

	public void submitReview() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		Integer rating = Integer.parseInt(request.getParameter("rating"));
		String headline = request.getParameter("headline");
		String comment = request.getParameter("comment");
		
		Review review = new Review();
		review.setComment(comment);
		review.setHeadline(headline);
		review.setRating(rating);
		
		Book book = new Book();
		book.setBookId(bookId);
		review.setBook(book);
		
		Customer customer = (Customer) request.getSession().getAttribute("loggedcustomer");
		review.setCustomer(customer);
		
		reviewDAO.create(review);
		
		String targetPage = "frontend/review_done.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(targetPage);
		requestDispatcher.forward(request, response);
		
		
	}
	
	

	
		

	

}
