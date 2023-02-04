package com.jdc.location.model.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.location.model.entity.District;

public interface DistrictRepo extends JpaRepositoryImplementation<District, Integer>{
	
	// Using Naming Rules
	List<District> findByStateRegionOrderByName(String region);
	
	// Using JPQL
	@Query("select d from District d where d.state.region = ?1 order by d.name desc")
	List<District> searchByRegion(String region);
	
	// Using Sort Parameter with naming rules
	List<District> findByStateRegion(String region, Sort sort);
	
	// Using Sort Parameter with JPQL
	@Query("select d from District d where d.state.region = ?1")
	List<District> searchByRegionSort(String region, Sort sort);
	
	/**
	 * Pagination with Naming Rules and Using JPQL
	 */
	
	// Using Naming Rule
	Page<District> findByStateRegion(String region, Pageable pageable);
	
	// Using JPQL
	@Query(
			value = "select d from District d where d.state.region = ?1",
			countQuery = "select count(d) from District d where d.state.region = ?1"
	)
	Page<District> searchByRegion(String region, Pageable pageable);
	
}
