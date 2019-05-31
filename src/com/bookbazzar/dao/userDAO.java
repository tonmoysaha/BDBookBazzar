package com.bookbazzar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookbazzar.entity.Users;

public class userDAO extends jpaDAO<Users> implements GenericDAO<Users> {

	public userDAO(EntityManager entityManager) {
		super(entityManager);

	}

	public Users create(Users user) {
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		return super.update(user);

	}

	@Override
	public Users get(Object userId) {

		return super.find(Users.class, userId);
	}
	public Users findByEmail(String email) {
		 List<Users> listUser = super.findWithNamedQery("Users.findByEmail","email",email);
		 
		 if (listUser != null && listUser.size() > 0) {
			 
			return listUser.get(0);
			
		}
		return null;
	}

	@Override
	public void delete(Object userId) {
		super.delete(Users.class, userId);

	}

	@Override
	public List<Users> listAll() {

		return super.findWithNamedQery("Users.findAll");
	}

	@Override
	public long count() {

		return super.countWithNamedQuery("Users.countAll");
	}


}
