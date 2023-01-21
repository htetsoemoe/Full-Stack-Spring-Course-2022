package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.demo.entity.Account;

public class LifecycleCallbackTest {
	
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
		var account = new Account();
		account.setName("Mi Mi");
		account.setBalance(500_000);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();	
		em.persist(account);
		em.getTransaction().commit();
	}
	
	@Test
	void test_update() {
		var em = emf.createEntityManager();
		var account = em.find(Account.class, 1);
		
		em.getTransaction().begin();
		account.setBalance(300_000);
		em.getTransaction().commit();
	}

}
