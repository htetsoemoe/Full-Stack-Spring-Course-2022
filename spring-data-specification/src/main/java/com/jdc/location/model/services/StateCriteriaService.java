package com.jdc.location.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.location.model.entity.State;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class StateCriteriaService {

	@PersistenceContext
	private EntityManager entityManager;
	
	// JPQL => select s from State s where s.region = region
	public List<State> findByRegion(String region) {
		
		// create 'Criteria Builder'
		var criteriaBuilder = entityManager.getCriteriaBuilder();
		
		// create 'Criteria Query'
		var criteriaQuery = criteriaBuilder.createQuery(State.class);
		
		// Create Root Object
		var root = criteriaQuery.from(State.class);
		
		// select s from State s
		criteriaQuery.select(root);
		
		// s.region = region
		var predicate = criteriaBuilder.equal(root.get("region"), region);
		
		// select s from State s where s.region = region
		criteriaQuery.where(predicate);
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}
