package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.query.entity.Category;

public class GettingStartTest extends AbstractTest{


	/**
	 * Static Query in JPA
	 */
	@Test
	void select_count() {

		var query = em.createNamedQuery("Category.allCount", Long.class);

		var count = query.getSingleResult();
		assertEquals(7, count);
	}

	@Test
	void select_all() {
		var query = em.createNamedQuery("Category.getAll", Category.class);

		var stream = query.getResultStream();
		stream.forEach(category -> System.out.println(category.getName()));
	}

	@Test
	void update() {
		em.getTransaction().begin();

		var query = em.createNamedQuery("Category.updateNameById");

		query.setParameter("name", "Mens");
		query.setParameter("id", 1);

		var count = query.executeUpdate();
		em.getTransaction().commit();

		assertEquals(1, count);
	}
	
	@ParameterizedTest
	@CsvSource({
		"f,2",
		"e,1"
	})
	void search_category_by_name_like(String name, int count) {
		var query = em.createNamedQuery("Category.findByNameLike", Category.class);
		query.setParameter(1, name.toLowerCase().concat("%"));
		
		var list = query.getResultList();
		assertEquals(count, list.size());
	}
	
	/**
	 * Dynamic Query in JPA
	 * 
	 * 
	 * @Test void select_count() {
	 * 
	 *       var query = em.createQuery(""" select count(c) from Category c """,
	 *       Long.class);
	 * 
	 *       var count = query.getSingleResult(); assertEquals(7, count); }
	 * 
	 * @Test void select_all() { var query = em.createQuery(""" select c from
	 *       Category c """, Category.class);
	 * 
	 *       var stream = query.getResultStream(); stream.forEach(category ->
	 *       System.out.println(category.getName())); }
	 * 
	 * @Test void update() { em.getTransaction().begin();
	 * 
	 *       var query = em.createQuery(""" update Category c set c.name = :name
	 *       where c.id = :id """);
	 * 
	 *       query.setParameter("name", "Mens"); query.setParameter("id", 1);
	 * 
	 *       var count = query.executeUpdate(); em.getTransaction().commit();
	 * 
	 *       assertEquals(1, count); }
	 * 
	 */

}
