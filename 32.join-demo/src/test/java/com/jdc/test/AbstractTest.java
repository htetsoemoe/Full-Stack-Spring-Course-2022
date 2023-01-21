package com.jdc.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class AbstractTest {
	
	protected EntityManagerFactory emf;
	protected EntityManager em;
	
	@BeforeEach
	void init() {
		emf = Persistence.createEntityManagerFactory("32.join-demo");
		em = emf.createEntityManager();
	}
	
	@AfterEach
	void close() {
		em.close();
		emf.close();
	}
	

}
