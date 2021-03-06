package com.bookbazzar.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookbazzar.entity.Users;

public class userDAOTest {
	private static userDAO userDAO;

	@BeforeClass
	public static void setUpClass() throws Exception {
		
		userDAO = new userDAO();
	}

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();

		user1.setEmail("akash@gmail.com");

		user1.setFullname("akash love dad");

		user1.setPassword("6666655");

		user1 = userDAO.create(user1);

		assertTrue(user1.getUserId() > 0);
	}

	@Test(expected = PersistenceException.class)
	public void testCreateUserFieldNOtSet() {
		Users user1 = new Users();

		user1 = userDAO.create(user1);
	}

	@Test
	public void testUpdateUser() {
		Users user1 = new Users();
		user1.setUserId(20);
		user1.setEmail("ma1@gmail.com");
		user1.setFullname("ma love");
		user1.setPassword("1111111");

		user1 = userDAO.update(user1);
		String expected = "1111111";
		String actual = user1.getPassword();

		assertEquals(expected, actual);
	}

	@Test
	public void testGetUserFound() {
		Integer userId = 21;
		Users user = userDAO.get(userId);
		System.out.println(user.getEmail());
		assertNotNull(user);

	}

	@Test
	public void testGetuserNotFound() {
		Integer userId = 99;
		Users user = userDAO.get(userId);
		assertNull(user);
	}

	@Test
	public void testDeleteUser() {
		Integer userId = 27;
		userDAO.delete(userId);
		Users user = userDAO.get(userId);
		assertNull(user);
	}

	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNotExistUser() {
		Integer userId = 27;
		userDAO.delete(userId);
	}

	@Test
	public void testListAllUser() {
		List<Users> listusers = userDAO.listAll();
		for (Users users : listusers) {
			System.out.println(users.getEmail()+ users.getPassword());
		}
		assertTrue(listusers.size() > 0);

	}

	@Test
	public void testCountAll() {
		long totallusers = userDAO.count();

		assertTrue(totallusers > 0);

	}

	@Test
	public void testFindByEmail() {
		String email = "dad@gmail.com";
		Users user = userDAO.findByEmail(email);

		assertNotNull(user);

	}

	@Test
	public void testCheckLogin() {
		String email = "ma@gmail.com";
		String password = "44444";
		boolean loginresult = userDAO.checkLogin(email, password);
		assertTrue(loginresult);
	}
	@Test
	public void testCheckLoginFail() {
		String email = "ma222@gmail.com";
		String password = "44444";
		boolean loginresult = userDAO.checkLogin(email, password);
		assertFalse(loginresult);
		
	}
	@Test
	public void testGenerateMD5() {
		String password = "9999";
		String encryptedPassword = HashGenerator.generateMD5(password);
		
		System.out.println(encryptedPassword);
		
		assertTrue(true);
	}
	@AfterClass
	public static void tearDownClass() throws Exception {
		userDAO.close();
	}

}
