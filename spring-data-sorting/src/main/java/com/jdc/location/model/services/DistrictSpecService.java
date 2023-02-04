package com.jdc.location.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	public List<District> searchByRegion(String region) {
		
		return repo.findAll((root, query, cb) -> {
			// order by d.name asc
			query.orderBy(cb.asc(root.get(District_.name)));
			
			// d.state.region = ?
			return cb.equal(root.get(District_.state).get(State_.region), region);
		});
	}
	
	public List<District> searchByRegionSort(String region, Sort sort) {
		return repo.findBy((root, query, cb) -> cb.equal(root.get(District_.state).get(State_.region), region),
				query -> query.sortBy(sort).all());
	}
}
