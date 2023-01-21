package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.demo.entity.Contact;
import com.jdc.demo.entity.Member;

public class CascadeTest {

	EntityManagerFactory emf;
	
	@ParameterizedTest
	@CsvSource("Soe Moe,soemoe,soemoe,09975341593,soemoe@gmail.com")
	void test(String name, String loginId, String phone, String email) {
		var member = new Member(name, loginId, email);
		var contact = new Contact(phone, email);
		member.addContact(contact);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(member);
		
		em.getTransaction().commit();
	}
	
	
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
}
