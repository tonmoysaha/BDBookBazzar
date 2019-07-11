package com.bookbazzar.dao;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookbazzar.entity.Book;
import com.bookbazzar.entity.Category;

public class BookDAOTest {
	private static BookDAO bookDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		bookDAO = new BookDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bookDAO.close();

	}

	@Test
	public void testCreateBook() throws ParseException, IOException {
		Book newBook = new Book();

		Category category = new Category("Java");
		category.setCategoryId(11);
		newBook.setCategory(category);
		newBook.setTitle("java Headfrist");
		newBook.setAuthor("Bert Bates");
		newBook.setDescription(
				"Learning a complex new language is no easy task especially when it s an object-oriented computer programming language like Java. You might think the problem is your brain.");
		newBook.setPrice(38.05f);
		newBook.setIsbn("0596009208");

		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
		Date publish = dateFormat.parse("02/11/2005");
		newBook.setPublishDate(publish);

		String imagePath = "C:\\Users\\tonmoysahaopi\\Documents\\image\\download.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newBook.setImage(imageBytes);

		Book resultBook = bookDAO.create(newBook);

		assertTrue(resultBook.getBookId() > 0);

	}

	@Test
	public void testCreateBook2() throws ParseException, IOException {
		Book newBook = new Book();
		Category category = new Category();
		category.setCategoryId(11);
		newBook.setCategory(category);
		newBook.setCategory(category);
		newBook.setTitle("java in action");
		newBook.setAuthor("Alan Mycroft");
		newBook.setDescription(
				"Learning a complex new language is no easy task especially when it s an object-oriented computer programming language like Java. You might think the problem is your brain.");
		newBook.setPrice(50.05f);
		newBook.setIsbn("9781617293566");

		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
		Date publish = dateFormat.parse("09/23/2018");
		newBook.setPublishDate(publish);

		String imagepath = "C:\\Users\\tonmoysahaopi\\Documents\\image\\download1.jpg";
		byte[] imagebyte = Files.readAllBytes(Paths.get(imagepath));
		newBook.setImage(imagebyte);

		Book resultBook = bookDAO.create(newBook);
		assertTrue(resultBook.getBookId() > 0);

	}

	@Test
	public void testUpdateBook() throws ParseException, IOException {
		Book existBook = new Book();
		existBook.setBookId(1);

		Category category = new Category("servlet");
		category.setCategoryId(22);
		existBook.setCategory(category);
		existBook.setTitle("java Headfrist new");
		existBook.setAuthor("Bert Bates");
		existBook.setDescription(
				"Learning a complex new language is no easy task especially when it s an object-oriented computer programming language like Java. You might think the problem is your brain.");
		existBook.setPrice(40f);
		existBook.setIsbn("0596009208");

		DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
		Date publish = dateFormat.parse("02/11/2005");
		existBook.setPublishDate(publish);

		String imagePath = "C:\\Users\\tonmoysahaopi\\Documents\\image\\download.jpg";
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		existBook.setImage(imageBytes);
		Book updateBook = bookDAO.update(existBook);
		assertEquals(updateBook.getTitle(), "java Headfrist new");
	}

	@Test
	public void testGetBook() {
		int bookId = 2;
		Book book = bookDAO.get(bookId);
		assertNotNull(book);

	}

	@Test
	public void testGetBookFail() {
		int bookId = 99;
		Book book = bookDAO.get(bookId);
		assertNull(book);
		// the book is not found with this id
	}

	@Test
	public void testDeleteBook() {
		int bookId = 1;
		bookDAO.delete(bookId);
		assertTrue(true);

	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteBookFail() {
		int bookId = 100;
		bookDAO.delete(bookId);
		// the book is not found with this id
	}

	@Test
	public void testListAll() {
		List<Book> booklist = bookDAO.listAll();
		for (Book book : booklist) {
			System.out.println(book.getTitle() + " " + book.getAuthor());
		}
		assertFalse(booklist.isEmpty());
	}

	@Test
	public void testFindByTitle() {
		String title = "java in action";
		Book findByTitle = bookDAO.findByTitle(title);
		assertNotNull(findByTitle);
	}

	@Test
	public void testFindByTitleNotFound() {
		String title = "Java";
		Book findByTitle = bookDAO.findByTitle(title);
		assertNull(findByTitle);
		// asserttrue is not work there

	}

	@Test
	public void testCount() {
	    long countBook = bookDAO.count();
	    assertEquals(2, countBook);
	}

	@Test
	public void testListByCategory() {
		int categoryId = 11;
		List<Book> listBook = bookDAO.listByCategory(categoryId);
		assertTrue(listBook.size() > 1);
	}
	@Test
	public void testListNewBooks() {
		List<Book> listNewBooks = bookDAO.listNewBooks();
		assertEquals(listNewBooks.size(), 4);
	}
	@Test
	public void testBookSearch() {
		String title = "java";
		List<Book> searchBook = bookDAO.search(title);
		assertEquals(4,searchBook.size());
	}
	@Test
	public void testBookSearchByAuthor() {
		String title = " Herbert Schildt";
		List<Book> searchBook = bookDAO.search(title);
		assertEquals(1,searchBook.size());
	}
	@Test
	public void testCountByCategory() {
		int categoryId = 11;
		long countByCategory = bookDAO.countByCategory(categoryId);
		assertTrue(countByCategory > 0);
	}


}
