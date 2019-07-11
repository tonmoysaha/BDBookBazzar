package com.bookbazzar.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bookbazzar.entity.Book;

public class BookDAO extends jpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO() {
	}

	@Override
	public Book create(Book book) {
		book.setLastUpdateTime(new Date());
		return super.create(book);
	}

	@Override
	public Book update(Book book) {
		book.setLastUpdateTime(new Date());
		return super.update(book);
	}

	@Override
	public Book get(Object bookId) {
		// TODO Auto-generated method stub
		return super.find(Book.class, bookId);
	}

	@Override
	public void delete(Object bookId) {
		super.delete(Book.class, bookId);

	}

	@Override
	public List<Book> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNamedQery("findAll.Book");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.countWithNamedQuery("Book.countAll");
	}

	public Book findByTitle(String title) {
		List<Book> titleList = super.findWithNamedQery("Book.findByTitle", "title", title);
		if (!titleList.isEmpty()) {
			return titleList.get(0);
		}
		return null;
		// check existing title

	}

	public List<Book> listByCategory(int categorey) {
		return super.findWithNamedQery("Book.findByCategory", "catId", categorey);

	}

	public List<Book> listNewBooks() {

		return super.findWithNamedQery("Book.newBookList", 0, 4);

	}

	public List<Book> search(String keyword) {
		return super.findWithNamedQery("Book.search", "keyword", keyword);

	}
	public long countByCategory(int categoryId) {
		return super.countWithNamedQuery("Book.countByCategory","catId", categoryId);
		
	}

}
