package com.bookbazzar.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAOTest {
	protected static EntityManagerFactory entityManagerFactory;
	protected static EntityManager entityManager;
	
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookBazzarWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		
	}
	public static void tearDownAfterClass() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
		
	}


}
