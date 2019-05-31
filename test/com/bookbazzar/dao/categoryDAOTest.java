package com.bookbazzar.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookbazzar.entity.Category;

public class categoryDAOTest extends BaseDAOTest {
	
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setUpBeforeClass();
		categoryDAO = new CategoryDAO(entityManager);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
		
	}

	@Test
	public void testCreateCategory() {
		Category category = new Category();
		category.setName("Politics");
		category = categoryDAO.create(category);
		assertTrue(category != null && category.getCategoryId() > 0);
	}

	@Test
	public void testUpdateCategory() {
		Category cat = new Category();
		cat.setCategoryId(11);
		cat.setName("Java");
		Category catagory = categoryDAO.update(cat);
		assertEquals(cat.getName(),catagory.getName());
	}

	@Test
	public void testGetCategory() {
		Integer id =11;
		Category category = categoryDAO.get(id);
		assertNotNull(category);
	}

	@Test
	public void testDeleteCategory() {
		Integer catid = 13;
		 categoryDAO.delete(catid);
		 Category category =  categoryDAO.get(catid);
		 assertNull(category);
		
	}

	@Test
	public void testListAll() {
		List<Category> listCategory = categoryDAO.listAll();
		//user lamda expression
		//listCategory.forEach(c -> System.out.println(c.getName()+","));
		assertTrue(listCategory.size()>0);
	}

	@Test
	public void testCount() {
		long categoryTotall = categoryDAO.count();
		assertEquals(7, categoryTotall);
		
	}
	

}
