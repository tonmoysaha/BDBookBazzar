package com.bookbazzar.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.bookbazzar.entity.Users;

public class userDAO extends jpaDAO<Users> implements GenericDAO<Users> {

	public userDAO() {

	}
    @Override
	public Users create(Users user) {
		String encryptedPassword = HashGenerator.generateMD5(user.getPassword());
		user.setPassword(encryptedPassword);
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

	public Users findByEmail(String email) {
		List<Users> listUser = super.findWithNamedQery("Users.findByEmail", "email", email);

		if (listUser != null && listUser.size() > 0) {
			return listUser.get(0);
		}
		return null;
	}

	public boolean checkLogin(String email, String password) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		String encryptedPassword = HashGenerator.generateMD5(password);
		parameters.put("email", email);
		parameters.put("password", encryptedPassword);
		List<Users> listUsers = super.findWithNamedQery("Users.checkLogin", parameters);
		if (listUsers.size() == 1) {
			return true;

		}
		return false;
	}

}
