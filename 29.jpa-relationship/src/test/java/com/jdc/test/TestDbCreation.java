package com.jdc.test;

import java.awt.Color;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.student.entity.Office;

public class TestDbCreation {
	
	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("29.jpa-relationship");
	}
	
	@AfterAll
	static void close() {
		if (null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@ParameterizedTest
	@CsvSource({
		"Thaw Thaw,thawthaw,thawthaw"
	})
	void test(String name, String loginId, String password) {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		var office = new Office(name, loginId, password);
		office.setColor(Color.YELLOW);
		
		em.persist(office);
		
		em.getTransaction().commit();
	}

}
