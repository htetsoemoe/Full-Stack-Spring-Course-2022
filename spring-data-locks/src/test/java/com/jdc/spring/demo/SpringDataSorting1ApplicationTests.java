package com.jdc.spring.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;

@SpringBootTest
class SpringDataSorting1ApplicationTests {
		
	@Autowired
	private EntityManager em;

	@Test
	@Transactional
	@Rollback(false)
	void contextLoads() {
		var account = em.find(Account.class, 1, LockModeType.WRITE);
		account.setName("Ko Htet");
	}

}
