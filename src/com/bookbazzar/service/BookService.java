package com.bookbazzar.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.bookbazzar.dao.BookDAO;
import com.bookbazzar.dao.CategoryDAO;
import com.bookbazzar.dao.OrderDAO;
import com.bookbazzar.entity.Book;
import com.bookbazzar.entity.Category;

public class BookService {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private BookDAO bookDAO;
	private CategoryDAO categoryDAO;

	public BookService(HttpServletRequest request, HttpServletResponse response) {

		
		this.request = request;
		this.response = response;
		bookDAO = new BookDAO();
		categoryDAO = new CategoryDAO();

	}

	public void listBook() throws ServletException, IOException {
		listBook(null);
	}

	public void listBook(String massage) throws ServletException, IOException {

		List<Book> bookList = bookDAO.listAll();

		if (massage != null) {
			request.setAttribute("massage", massage);
		}

		request.setAttribute("bookList", bookList);
		String listpath = "book_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listpath);
		requestDispatcher.forward(request, response);
	}

	public void showNewBookForm() throws ServletException, IOException {

		List<Category> listCategory = categoryDAO.listAll();

		request.setAttribute("listCategory", listCategory);
		String bookForm = "book_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(bookForm);
		requestDispatcher.forward(request, response);
	}

	public void createBook() throws ServletException, IOException {

		String title = request.getParameter("title");

		Book exisBook = bookDAO.findByTitle(title);

		if (exisBook != null) {
			String message = "The book could not create with this title '" + title + "' already exist";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
			return;
		}

		Book newBook = new Book();
		readBookFields(newBook);

		Book createBook = bookDAO.create(newBook);
		if (createBook.getBookId() > 0) {
			String massage = "book created successfully";
			listBook(massage);
		}
	}

	public void readBookFields(Book book) throws ServletException, IOException {

		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		float price = Float.parseFloat(request.getParameter("price"));
		String description = request.getParameter("description");

		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date publishDate = null;
		try {
			publishDate = dateFormat.parse(request.getParameter("publishDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException("error parsing publish date (formate is mm/dd/yyy)");
		}

		Category category = categoryDAO.get(categoryId);
		book.setCategory(category);
		book.setTitle(title);
		book.setAuthor(author);
		book.setIsbn(isbn);
		book.setPrice(price);
		book.setDescription(description);
		book.setPublishDate(publishDate);

		Part filePart = request.getPart("bookImage");
		if (filePart != null && filePart.getSize() > 0) {
			long size = filePart.getSize();
			byte[] imageBytes = new byte[(int) size];
			InputStream inputStream = filePart.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			book.setImage(imageBytes);
		}

	}

	public void editBook() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));

		Book book = bookDAO.get(bookId);

		if (book == null) {
			String message = "This Book is not Found With This Id '" + bookId + "'";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
			return;

		}

		List<Category> listCategory = categoryDAO.listAll();
		request.setAttribute("listCategory", listCategory);

		request.setAttribute("book", book);
		String editpage = "book_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editpage);
		requestDispatcher.forward(request, response);

	}

	public void updateBook() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("bookId"));
		String title = request.getParameter("title");

		Book existBook = bookDAO.get(bookId);
		readBookFields(existBook);

		Book findByTitle = bookDAO.findByTitle(title);

		if (findByTitle != null && !existBook.equals(findByTitle)) {
			String massage = "The book could not be update Because the" + title + "already exist";
			listBook(massage);
			return;
		}

		bookDAO.update(existBook);
		String massage = "The Book is successfull updated";
		listBook(massage);
	}

	public void deleteBook() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookDAO.get(bookId);

		if (book == null) {
			String message = "This Book is not Found With This Id '" + bookId + "'";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
			return;
		} else {
			if (!book.getReviews().isEmpty()) {
				String message = "The Book could not Delete with this title '" + book.getTitle()
						+ "'because it has reviews";
				request.setAttribute("message", message);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
				requestDispatcher.forward(request, response);
				return;
			} else {
				OrderDAO orderDAO = new OrderDAO();
				long countByOrder = orderDAO.countOrderDetailByBook(bookId);

				if (countByOrder > 0) {
					String massage = "Could not delete book with ID " + bookId
							+ " because there are orders associated with it.";
					listBook(massage);
				} else {
					bookDAO.delete(bookId);

					String massage = "The book has been deleted succeddfully";

					listBook(massage);

				}
			}
		}
	}

	public void listBooksByCategory() throws ServletException, IOException {
		Integer categoryId = Integer.parseInt(request.getParameter("id"));// id from fronted header
		List<Book> listBooks = bookDAO.listByCategory(categoryId);
		Category category = categoryDAO.get(categoryId);
		if (category == null) {
			String message = "This Category is no longer availabel With This Id '" + category.getName() + "'";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
			return;
		}

		request.setAttribute("listBooks", listBooks);
		request.setAttribute("category", category);

		String listPage = "frontend/book_list_by_category.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);

	}

	public void viewBookDetails() throws ServletException, IOException {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookDAO.get(bookId);
		if (book == null) {
			String message = "This Book is no longer availabel With This Id '" + book.getTitle() + "'";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("massage.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		request.setAttribute("book", book);
		String listPage = "frontend/book_details.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);

	}

	public void searchBook() throws ServletException, IOException {
		String keyword = request.getParameter("keyword");

		List<Book> searchBook = null;

		if (keyword.equals("")) {
			searchBook = bookDAO.listAll();
		} else {
			searchBook = bookDAO.search(keyword);
		}

		request.setAttribute("searchBook", searchBook);
		request.setAttribute("keyword", keyword);
		String searchPage = "frontend/search_result.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(searchPage);
		requestDispatcher.forward(request, response);

	}
	
	

}
