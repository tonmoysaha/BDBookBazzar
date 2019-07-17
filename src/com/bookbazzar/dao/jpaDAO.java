package com.bookbazzar.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bookbazzar.entity.Users;

public class jpaDAO<E> {
	private static EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookBazzarWebsite");
	}

	public jpaDAO() {

	}

	public E create(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;

	}

	public E update(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entity = entityManager.merge(entity);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		return entity;
	}

	public E find(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		E entity = entityManager.find(type, id);
		if (entity != null) {
			entityManager.refresh(entity);
		}
		
		entityManager.close();
		return entity;
	}

	public void delete(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Object reference = entityManager.getReference(type, id);
		entityManager.remove(reference);
		entityManager.getTransaction().commit();
		
		entityManager.close();

	}

	public List<E> findWithNamedQery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		List<E> result = query.getResultList();

		entityManager.close();
		return result;
		// list all data

	}
	public List<E> findWithNamedQery(String queryName,int fristResult,int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		query.setFirstResult(fristResult);
		query.setMaxResults(maxResult);
		
		List<E> result = query.getResultList();
		entityManager.close();
		return result;
		// list all data

	}
	public List<Object[]> findWithNamedQeryObject(String queryName,int fristResult,int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		query.setFirstResult(fristResult);
		query.setMaxResults(maxResult);
		
		List<Object[]> result = query.getResultList();
		entityManager.close();
		return result;
		// list all data

	}

	public List<E> findWithNamedQery(String queryName, String paramName, Object paramValue) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramName, paramValue);
		List<E> result = query.getResultList();

		entityManager.close();
		return result;
		// use infind by email,category,title

	}

	public long countWithNamedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		long result = (long) query.getSingleResult();
		
		/// count the totall number
		entityManager.close();
		return result;

	}

	public List<E> findWithNamedQery(String queryName, Map<String, Object> parameter) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		Set<Entry<String, Object>> setParameters = parameter.entrySet();
		for (Entry<String, Object> entry : setParameters) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		// for login details check
		List<E> result = query.getResultList();

		entityManager.close();
		return result;
	}
	public long countWithNamedQuery(String queryName ,String paramName , Object paramValue) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramName, paramValue);
		
		long result = (long) query.getSingleResult();
		
		/// count the totall number
		entityManager.close();
		return result;

	}
	
	public void close()
	{
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}

}
