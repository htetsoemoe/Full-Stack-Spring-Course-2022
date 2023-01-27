package com.jdc.location.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.location.model.dto.StateDto;
import com.jdc.location.model.entity.District;
import com.jdc.location.model.entity.State;
import com.jdc.location.model.repo.DistrictRepo;
import com.jdc.location.model.repo.StateRepo;

@Service
public class StateSpecServices {

	@Autowired
	private StateRepo stateRepo;
	
	@Autowired
	private DistrictRepo districtRepo;
	
	// helper method
	public Specification<State> byRegion(String region) {
		return (root, query, criteriaBuilder) -> 
					criteriaBuilder.equal(root.get("region"), region);
	}
	
	// select s from State s where s.region = region
	public List<State> findByRegion(String region) {
		return stateRepo.findAll(byRegion(region));
	}
	
	public long findCountByRegion(String region) {
		return stateRepo.count(byRegion(region));
	}
	
	// find all region using DTO (interface)
	public List<StateDto> findDtoByRegion(String region) {
		return stateRepo.findBy(byRegion(region), 
				query -> query.project("id", "name", "region").as(StateDto.class).all());
	}
	
	@Transactional
	public long deleteByRegion(String region) {		
		// Delete Districts
		deleteDistrictByRegion(region);
		return stateRepo.delete(byRegion(region));
	}
	
	// Delete Districts first
	private long deleteDistrictByRegion(String region) {
		
		//		Specification<District> spec = (root, query, criteriaBuilder) -> 
		//		criteriaBuilder.equal(root.get("state").get("region"), region);
		
		var districts = districtRepo.findByStateRegion(region);
		
		Specification<District> spec = (root, query, criteriaBuilder) -> 
								root.in(districts);
		return districtRepo.delete(spec);
	}
	
	/**
	 * 
Hibernate: 
    select
        d1_0.id,
        d1_0.name,
        d1_0.state_id 
    from
        district d1_0 
    join
        state s1_0 
            on s1_0.id=d1_0.state_id 
    where
        s1_0.region=?
Hibernate: 
    select
        s1_0.id,
        s1_0.capital,
        s1_0.name,
        s1_0.porpulation,
        s1_0.region,
        s1_0.type 
    from
        state s1_0 
    where
        s1_0.id=?
Hibernate: 
    select
        s1_0.id,
        s1_0.capital,
        s1_0.name,
        s1_0.porpulation,
        s1_0.region,
        s1_0.type 
    from
        state s1_0 
    where
        s1_0.id=?
Hibernate: 
    delete 
    from
        district 
    where
        id in(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
Hibernate: 
    delete 
    from
        state 
    where
        region=?
	 */
}
