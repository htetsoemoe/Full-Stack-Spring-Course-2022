package com.jdc.spring.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
public class RelatedEntityLockDemo {
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	void test() {
		var account = em.find(Account.class, 1, LockModeType.PESSIMISTIC_WRITE);
		
		var profile = account.getProfile();
		
		profile.setDescription("Hey There!");
	}

}
