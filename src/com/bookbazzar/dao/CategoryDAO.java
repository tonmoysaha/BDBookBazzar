package com.bookbazzar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookbazzar.entity.Category;

public class CategoryDAO extends jpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);

	}

	@Override
	public Category create(Category category) {

		return super.create(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return super.update(category);
	}

	@Override
	public Category get(Object id) {
		// TODO Auto-generated method stub
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id);

	}

	@Override
	public List<Category> listAll() {
		// TODO Auto-generated method stub
		return super.findWithNamedQery("Category.findAll");
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("Category.countAll");
	}

}
