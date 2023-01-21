package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.demo.entity.Contact;
import com.jdc.demo.entity.Member;

public class RemoveTest {
	
	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("30.entity-manager");
	}
	
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test_remove(int id) {
		var em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		var member = em.find(Member.class, id);
		assertNotNull(member);
		
		em.remove(member);
		assertFalse(em.contains(member));
		
		em.getTransaction().commit();
		
		em = emf.createEntityManager();
		member = em.find(Member.class, id);
		assertNotNull(member);
	}
	
	@AfterAll
	static void shutdown() {
		if (null != emf && emf.isOpen()) {
			emf.close();
		}
	}

}
