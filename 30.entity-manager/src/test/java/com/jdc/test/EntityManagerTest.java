package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.annotations.Parent;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.demo.entity.Member;
import com.jdc.demo.entity.Member.Role;

@TestMethodOrder(OrderAnnotation.class)
public class EntityManagerTest {
	
	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("30.entity-manager");
	}
	
	@Order(1)
	@ParameterizedTest
	@CsvSource("Soe Moe, soemoe, soemoe")
	void test_creation(String name, String loginId, String password) {
		// Transient State 
		var member = new Member(name, loginId, password);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// to become 'Persistence State'(Managed State) or in 'Persistence Context'
		em.persist(member);
		assertEquals(2, member.getId());
		
		// Is entity contains in persistence context, check with contains()
		assertTrue(em.contains(member));
		
		// Making entity to detach state
		em.detach(member);
		
		assertFalse(em.contains(member));
		
		// To detached state to managed state
		member = em.merge(member);
		
		member.setRole(Role.Admin);
		
		// Synchronized to Database
		em.getTransaction().commit();
			
	}
	
	@Order(2)
	@ParameterizedTest
	@ValueSource(ints = 1)
	void test_find(int id) {
		
		var em = emf.createEntityManager();
		var member = em.find(Member.class, id);
		assertNotNull(member);
		
		assertTrue(em.contains(member));
		
		em.detach(member);
		
		assertAll(
				() -> assertEquals("Thaw Thaw", member.getName()),
				() -> assertEquals(Role.Admin, member.getRole()),
				() -> assertEquals("admin", member.getLoginId())
		);
	}
	
	
	@AfterAll
	static void close() {
		if (null != emf && emf.isOpen()) {
			emf.close();
		}
	}

}
