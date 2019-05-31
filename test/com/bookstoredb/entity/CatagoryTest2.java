package com.bookstoredb.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookbazzar.entity.Category;
import com.bookbazzar.entity.Users;

public class CatagoryTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Category newCat = new Category("core java");

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookBazzarWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(newCat);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

		System.out.println("Category object insert successfully");

	}

}
