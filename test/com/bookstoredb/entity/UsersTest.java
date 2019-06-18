package com.bookstoredb.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookbazzar.entity.Users;

public class UsersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Users user1 = new Users();
		user1.setEmail("piki1@gmail.com");
		user1.setFullname("piki and opi love  ma");
		user1.setPassword("1111");
		
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("BookBazzarWebsite");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(user1);
    entityManager.getTransaction().commit();
    
    entityManager.close();
    entityManagerFactory.close();
    
    System.out.println("object insert successfully");
    
    
    
	}

}
