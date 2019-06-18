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
		return super.update(category);
	}

	@Override
	public Category get(Object id) {
		return super.find(Category.class, id);
	}

	@Override
	public void delete(Object id) {
		super.delete(Category.class, id);

	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQery("Category.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Category.countAll");
	}

	public Category findByName(String categoryName) {
		List<Category> resultName = super.findWithNamedQery("Category.findByName", "name", categoryName);
		if (resultName != null && resultName.size() > 0) {
			return resultName.get(0);
		}
		return null;
	}

}
