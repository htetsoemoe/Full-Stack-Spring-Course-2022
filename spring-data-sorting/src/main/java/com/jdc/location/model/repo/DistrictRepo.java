package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.location.model.entity.District;

public interface DistrictRepo extends JpaRepositoryImplementation<District, Integer>{
	
	// Using Naming Rules
	List<District> findByStateRegionOrderByName(String region);
	
	// Using JPQL
	@Query("select d from District d where d.state.region = ?1 order by d.name desc")
	List<District> searchByRegion(String region);
}
