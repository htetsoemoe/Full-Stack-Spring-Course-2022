package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.entity.Company;
import com.jdc.entity.Member;

public class MemberTest {
	
	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("27.getting-start-jpa"); // persistence unit name in presistence.xml 
	}
	
	@AfterAll
	static void close() {
		if (null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void test_create_member() {
		var member = new Member("Thaw Thaw", "099412088242", "tt@gmail.com", "Mandalay");
		
		// create entity_manager from Entity_Manager_Factory
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// persist Member object to Database 
		em.persist(member);
		System.out.println("Member ID is %s.".formatted(member.getId()));
		
		var company = new Company();
		company.setName("TT");
		em.persist(company);
		System.out.println("Company ID is %s.".formatted(company.getId()));
		
		// commit transaction 
		em.getTransaction().commit();
	}

}
