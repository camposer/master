package com.indra.formacion.hibernate.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.indra.formacion.hibernate.model.Libro;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("LibreriaJPA");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		/******** Pidiendo transacción e inicializándola ********/ 
		EntityTransaction et = em.getTransaction();
		
		/********* Insertando ********/
		Libro libro = new Libro();
		libro.setPrecio(90);
		libro.setTitulo("Noventa");
		libro.setAutor("Noventa");
		
		et.begin();
		try { /*** Esto no es obligatorio porque las excepciones son no-verificadas! ***/
			em.persist(libro);
			et.commit();
		} catch (PersistenceException pe) {
			et.rollback();
			pe.printStackTrace();
		}
		
		/********* Actualización ********/
		//libro.setTitulo(libro.getTitulo() + " modificado");
		et.begin();
		em.persist(libro); // Esto es posible (la actualización) porque libro es un objeto persistente en este momento 
		et.commit();
		
		Libro l1 = em.find(Libro.class, 1); // Este es libro con id = 1
		System.out.println("l1.getId = " + l1.getId());
		l1.setTitulo(l1.getTitulo() + " modificado");
		et.begin();
		em.persist(l1);  
		et.commit();
		
		/********* Eliminación ********/
		//l1 = em.find(Libro.class, 1); // Este es libro con id = 1
		//em.remove(l1);
		et.begin();
		em.remove(libro);
		et.commit();
		
		/********* Eliminación ********/
		// HQL (de toda la vida)
		for (Libro l : (List<Libro>)em.createQuery("from Libro").getResultList()) {
			System.out.println(l);
		}

		// Named query
		for (Libro l : (List<Libro>)em.createNamedQuery("Libro.findAll").getResultList()) {
			System.out.println(l);
		}

		// HQL con parámetro
		//Query createQuery = em.createQuery("from Libro where id = ?");
		//createQuery.setParameter(1, 1);
		Query createQuery = em.createQuery("from Libro where id = :id");
		createQuery.setParameter("id", 1);
		for (Libro l : (List<Libro>)createQuery.getResultList()) {
			System.out.println(l);
		}
		

		/******** Finalizando *******/
		em.close();
		
	}

}
