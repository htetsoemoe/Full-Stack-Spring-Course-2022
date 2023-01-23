package com.jdc.location.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.location.model.entity.State;
import com.jdc.location.model.repo.StateRepo;

@Service
public class StateSpecServices {

	@Autowired
	private StateRepo stateRepo;
	
	// select s from State s where s.region = region
	public List<State> findByRegion(String region) {
		Specification<State> specification = (root, query, criteriaBuilder) -> 
			criteriaBuilder.equal(root.get("region"), region);
		
		return stateRepo.findAll(specification);
	}
}
