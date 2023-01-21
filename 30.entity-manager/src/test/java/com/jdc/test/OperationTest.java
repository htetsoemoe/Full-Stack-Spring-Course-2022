package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class OperationTest {
	protected static EntityManagerFactory emf;
	
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
	
	abstract void operate_to_transient(int id, String name, String loginId, String password);
	abstract void operate_to_manage(int id);
	abstract void operate_to_detached(int id);
	abstract void operate_to_removed(int id);
}
