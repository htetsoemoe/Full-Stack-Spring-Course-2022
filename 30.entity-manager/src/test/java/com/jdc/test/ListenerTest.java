package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.demo.entity.Member;

public class ListenerTest {
	private EntityManagerFactory emf;
	
	@BeforeEach
	void init() {
		emf = Persistence.createEntityManagerFactory("30.entity-manager");
	}
	
	@AfterEach
	void shutdown() {
		if (null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void test_create() {
		var member = new Member("Mi Mi", "mimi", "mimi");
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();	
		em.persist(member);
		em.getTransaction().commit();
	}
	
	@Test
	void test_update() {
		var em = emf.createEntityManager();
		var member = em.find(Member.class, 1);
		
		em.getTransaction().begin();
		member.setName("Mi Mi");
		em.getTransaction().commit();
	}
}
