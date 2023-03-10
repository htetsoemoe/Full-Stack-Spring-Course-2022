package com.jdc.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jdc.demo.entity.Account;

public class PersistenceContextSyncTest {
	static EntityManagerFactory emf;
	
	@BeforeEach
	void init() {
		emf = Persistence.createEntityManagerFactory("30.entity-manager");
	}
	
	@AfterEach
	void close() {
		if(null != emf && emf.isOpen()) {
			emf.close();
		}
	}
	
	@Test
	void test() {
		var operation1 = getThreadOne();
		var operation2 = getThreadTwo();
		
		operation1.start();
		operation2.start();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private Thread getThreadOne() {
		return new Thread(() -> {
			System.out.println("Started Thread 1...");
			var em = emf.createEntityManager();
			var account = em.find(Account.class, 1);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			em.getTransaction().begin();
			System.out.println("Before Operation 1 : Balance of %s is %d".formatted(account.getName(), account.getBalance()));
			
			account.setBalance(account.getBalance() + 100_000);
			em.flush();//Synchronize the persistence context to the underlying database.
			
			System.out.println("After Operation 1 : Balance of %s is %d".formatted(account.getName(), account.getBalance()));
			
			em.getTransaction().commit();
		});
	}
	
	private Thread getThreadTwo() {
		return new Thread(() -> {
			System.out.println("Started Thread 2...");
			var em = emf.createEntityManager();
			var account = em.find(Account.class, 1);
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			em.getTransaction().begin();
			System.out.println("Before Operation 2 : Balance of %s is %d".formatted(account.getName(), account.getBalance()));
			
			em.refresh(account);// Refresh the state of the instance from the database,overwriting changes made to the entity, if any
			System.out.println("Before Operation 2 : Balance of %s is %d (Refreshed!)".formatted(account.getName(), account.getBalance()));
			
			account.setBalance(account.getBalance() - 50_000);
			System.out.println("After Operation 2 : Balance of %s is %d".formatted(account.getName(), account.getBalance()));
			
			em.getTransaction().commit();
		});
	}
	
}
