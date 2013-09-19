package com.emarket.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class BaseDao<T, K> implements IDao<T, K> {
	private EntityManager entityManager;
	
	private Class<T> clase;
	private boolean autoCommit;

	public BaseDao(EntityManagerFactory entityManagerFactory) {
		this(entityManagerFactory, true);
	}
	
	@SuppressWarnings("unchecked")
	public BaseDao(EntityManagerFactory entityManagerFactory, boolean autoCommit) {
		this.autoCommit = autoCommit;
		clase = (Class<T>) 
                ((ParameterizedType)getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
		
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public void agregar(T obj) {
		modificar(obj);
	}
	
	@Override
	public T obtener(K key) {
		T result = entityManager.find(clase, key);
		
		return result;
	}
	
	@Override
	public List<T> obtenerTodos() {
		List<T> list = entityManager.createQuery("from " + clase.getName(), clase).getResultList();
		
		return list;
	}
	
	@Override
	public void remover(K key) {
		try {
			if (autoCommit)
				entityManager.getTransaction().begin();

			T obj = obtener(key);
			entityManager.remove(obj);

			if (autoCommit)
				entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			
			if (autoCommit)
				entityManager.getTransaction().rollback();
		}
	}
	
	@Override
	public void modificar(T obj) {
		try {
			if (autoCommit)
				entityManager.getTransaction().begin();

			entityManager.persist(obj);			

			if (autoCommit)
				entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			
			if (autoCommit)
				entityManager.getTransaction().rollback();
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}
