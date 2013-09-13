package com.indra.formacion.hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class BaseDao<T, K> implements IDao<T, K> {
	// TODO: Resolver cómo sería sin autowired
	private EntityManager entityManager;
	protected EntityManagerFactory entityManagerFactory; 
	protected boolean autoCommit;
	private Class<T> clase;

	public BaseDao() {
		this(true); // Por defecto autoCommit
	}

	@SuppressWarnings("unchecked")
	public BaseDao(boolean autoCommit) {
		this.autoCommit = autoCommit;
		this.clase = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];;
	}
	
	protected void init() {
		if (autoCommit)
			this.entityManager = entityManagerFactory.createEntityManager();
	}

	public boolean isAutoCommit() {
		return autoCommit;
	}

	public void setAutoCommit(boolean autoCommit) {
		this.autoCommit = autoCommit;
	}

	@Override
	public void agregar(T obj) {
		entityManager.persist(obj);
		
	}

	@Override
	public void modificar(T obj) {
		entityManager.merge(obj);
	}

	@Override
	public void eliminar(K clave) {
		T elemento = obtener(clave);
		if (elemento != null)
			entityManager.remove(elemento);
	}

	@Override
	public T obtener(K clave) {
		EntityManager entityManager = this.entityManager;
		if (entityManager == null)
			entityManager = entityManagerFactory.createEntityManager();
		
		return entityManager.find(clase, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> obtenerTodos() {
		EntityManager entityManager = this.entityManager;
		if (entityManager == null)
			entityManager = entityManagerFactory.createEntityManager();

		return (List<T>) entityManager.createQuery("from " + clase.getName()).getResultList();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
