package com.jdc.location.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.jdc.location.model.entity.District;
import com.jdc.location.model.entity.District_;
import com.jdc.location.model.entity.State_;
import com.jdc.location.model.repo.DistrictRepo;

// Using Specification API

@Service
public class DistrictSpecService {

	@Autowired
	private DistrictRepo repo;
	
	// create 'sorting' with 'CriteriaBuilder'
	public List<District> searchByRegion(String region) {
		
		return repo.findAll((root, query, cb) -> {
			// order by d.name asc
			query.orderBy(cb.asc(root.get(District_.name)));
			
			// d.state.region = ?
			return cb.equal(root.get(District_.state).get(State_.region), region);
		});
	}
	
	// using 'Sort' parameter
	public List<District> searchByRegionSort(String region, Sort sort) {
		return repo.findBy(forRegion(region),
				query -> query.sortBy(sort).all());
	}
	
	// Pagination
	public Page<District> searchByRegion(String region, Pageable page) {
		return repo.findBy(forRegion(region), query -> query.page(page));
	}
	
	
	// helper method
	private Specification<District> forRegion(String region) {
		return (root, query, cb) -> cb.equal(root.get(District_.state).get(State_.region), region);
	}
}
